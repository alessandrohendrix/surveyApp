package com.surveyapp.survey.service.survey.impl;

import com.surveyapp.survey.domain.dto.survey.OpenQuestionDTO;
import com.surveyapp.survey.domain.dto.survey.ProductQuestionsDTO;
import com.surveyapp.survey.domain.dto.survey.StandardQuestionDTO;
import com.surveyapp.survey.domain.dto.survey.SurveyQuestionDTO;
import com.surveyapp.survey.domain.entities.product.Competitor;
import com.surveyapp.survey.domain.entities.product.Product;
import com.surveyapp.survey.domain.entities.survey.*;
import com.surveyapp.survey.repository.survey.CompetitorOpenQuestionRepository;
import com.surveyapp.survey.repository.survey.CompetitorStandardQuestionRepository;
import com.surveyapp.survey.service.survey.SurveyQuestionAggregatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

@Service
public class SurveyQuestionAggregatorServiceImpl implements SurveyQuestionAggregatorService {

    private final CompetitorStandardQuestionRepository competitorStandardQuestionRepository;
    private final CompetitorOpenQuestionRepository competitorOpenQuestionRepository;
    private final StandardQuestionMapper standardQuestionMapper;
    private final OpenQuestionMapper openQuestionMapper;
    private final ProductMapper productMapper;
    private final CompetitorMapper competitorMapper;

    @Autowired
    public SurveyQuestionAggregatorServiceImpl(
            CompetitorStandardQuestionRepository competitorStandardQuestionRepository,
            CompetitorOpenQuestionRepository competitorOpenQuestionRepository,
            StandardQuestionMapper standardQuestionMapper,
            OpenQuestionMapper openQuestionMapper,
            ProductMapper productMapper,
            CompetitorMapper competitorMapper) {

        this.competitorStandardQuestionRepository = competitorStandardQuestionRepository;
        this.competitorOpenQuestionRepository = competitorOpenQuestionRepository;
        this.standardQuestionMapper = standardQuestionMapper;
        this.openQuestionMapper = openQuestionMapper;
        this.productMapper = productMapper;
        this.competitorMapper = competitorMapper;
    }

    @Override
    public SurveyQuestionDTO aggregateQuestions(Survey survey) {

        Product product = survey.getProduct();
        Set<Competitor> competitors = product.getCompetitors();
        Set<ProductStandardQuestion> productStandardQuestions = survey.getProductStandardQuestions();
        Set<ProductOpenQuestion> productOpenQuestions = survey.getProductOpenQuestions();
        Map<Integer, ProductQuestionsDTO> competitorsQuestions = aggregateCompetitorsQuestions(competitors, survey);
        ProductQuestionsDTO productQuestionsDTO = buildProductQuestionsDTO(
                productStandardQuestions,
                productOpenQuestions
        );
        SurveyQuestionDTO surveyQuestionDTO = buildSurveyQuestionDTO(
                product,
                competitors,
                productQuestionsDTO,
                competitorsQuestions
        );
        return surveyQuestionDTO;
    }

    private Map<Integer, ProductQuestionsDTO> aggregateCompetitorsQuestions(Set<Competitor> competitors,
                                                                                    Survey survey) {

        Map<Integer, ProductQuestionsDTO> competitorsStandardQuestions = new HashMap<>();
        competitors.forEach(competitor -> {
            List<CompetitorStandardQuestion> standardQuestions = competitorStandardQuestionRepository
                    .findAllByCompetitorAndSurvey(competitor, survey);
            List<CompetitorOpenQuestion> openQuestions = competitorOpenQuestionRepository
                    .findAllByCompetitorAndSurvey(competitor, survey);
            Set<StandardQuestionDTO> standardDTO = standardQuestionMapper
                    .competitorStandardQuestionsToStandardQuestionDTOs(new HashSet<>(standardQuestions));
            Set<OpenQuestionDTO> openDTO = openQuestionMapper
                    .competitorOpenQuestionsToOpenQuestionDTOs(new HashSet<>(openQuestions));
            competitorsStandardQuestions.put(competitor.getID(), new ProductQuestionsDTO(standardDTO, openDTO));
        });
        return competitorsStandardQuestions;
    }

    private SurveyQuestionDTO buildSurveyQuestionDTO(Product product,
                                                     Set<Competitor> competitors,
                                                     ProductQuestionsDTO productQuestions,
                                                     Map<Integer, ProductQuestionsDTO> competitorsQuestions) {

        return new SurveyQuestionDTO(
                productMapper.productToProductDTO(product),
                competitorMapper.competitorsToCompetitorDTOs(competitors),
                productQuestions,
                competitorsQuestions
        );
    }

    private ProductQuestionsDTO buildProductQuestionsDTO(Set<ProductStandardQuestion> productStandardQuestions,
                                                         Set<ProductOpenQuestion> productOpenQuestions) {

        return new ProductQuestionsDTO(
                standardQuestionMapper.standardQuestionsToStandardQuestionDTOs(productStandardQuestions),
                openQuestionMapper.openQuestionsToOpenQuestionDTOs(productOpenQuestions)
        );
    }
}
