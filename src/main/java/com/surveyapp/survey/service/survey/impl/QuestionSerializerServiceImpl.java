package com.surveyapp.survey.service.survey.impl;

import com.surveyapp.survey.domain.dto.survey.*;
import com.surveyapp.survey.domain.entities.product.Competitor;
import com.surveyapp.survey.domain.entities.survey.*;
import com.surveyapp.survey.domain.entities.survey.Enum.SectionEnum;
import com.surveyapp.survey.mapper.survey.OpenQuestionMapper;
import com.surveyapp.survey.mapper.survey.StandardQuestionMapper;
import com.surveyapp.survey.repository.survey.CompetitorOpenQuestionRepository;
import com.surveyapp.survey.repository.survey.CompetitorStandardQuestionRepository;
import com.surveyapp.survey.service.survey.QuestionSerializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionSerializerServiceImpl implements QuestionSerializerService {

    private final CompetitorStandardQuestionRepository competitorStandardQuestionRepository;
    private final CompetitorOpenQuestionRepository competitorOpenQuestionRepository;
    private final StandardQuestionMapper standardQuestionMapper;
    private final OpenQuestionMapper openQuestionMapper;

    @Autowired
    public QuestionSerializerServiceImpl(
            CompetitorStandardQuestionRepository competitorStandardQuestionRepository,
            CompetitorOpenQuestionRepository competitorOpenQuestionRepository,
            StandardQuestionMapper standardQuestionMapper,
            OpenQuestionMapper openQuestionMapper) {

        this.competitorStandardQuestionRepository = competitorStandardQuestionRepository;
        this.competitorOpenQuestionRepository = competitorOpenQuestionRepository;
        this.standardQuestionMapper = standardQuestionMapper;
        this.openQuestionMapper = openQuestionMapper;
    }

    @Override
    public SurveyQuestionDTO aggregateQuestions(Survey survey, Set<Competitor> competitors) {

        Map<SectionEnum, ProductQuestionsDTO> productQuestions = aggregateProductQuestions(
                survey.getProductStandardQuestions(),
                survey.getProductOpenQuestions()
        );
        Map<SectionEnum, CompetitorsQuestionsDTO> competitorsQuestions = aggregateCompetitorsQuestions(competitors, survey);
        SurveyQuestionDTO surveyQuestionDTO = buildSurveyQuestionDTO(
                productQuestions,
                competitorsQuestions
        );
        return surveyQuestionDTO;
    }

    private Map<SectionEnum, ProductQuestionsDTO> aggregateProductQuestions(
            Set<ProductStandardQuestion> productStandardQuestions,
            Set<ProductOpenQuestion> productOpenQuestions) {

        Map<SectionEnum, ProductQuestionsDTO> productQuestions = new HashMap<>();
        SectionEnum.getSections()
                .forEach(section -> productQuestions.put(section, null));
        SectionEnum.getSections()
                .forEach(sectionName -> {
                    Set<StandardQuestionDTO> standardQuestionDTOs = generateSectionStandardQuestionDTOs(
                            productStandardQuestions, sectionName
                    );

                    Set<OpenQuestionDTO> openQuestionDTOs = productOpenQuestions
                            .stream()
                            .filter(question -> question.getSection().getSectionName() == sectionName)
                            .map(openQuestionMapper::productOpenQuestionToOpenQuestionDTO)
                            .collect(Collectors.toSet());
                    productQuestions.replace(sectionName, buildProductQuestionsDTO(standardQuestionDTOs, openQuestionDTOs));
                });
        return productQuestions;
    }

    private Map<SectionEnum, CompetitorsQuestionsDTO> aggregateCompetitorsQuestions(Set<Competitor> competitors,
                                                                                    Survey survey) {

        Map<SectionEnum, CompetitorsQuestionsDTO> competitorsQuestions = new HashMap<>();
        SectionEnum.getSections()
                .forEach(section -> competitorsQuestions.put(section, new CompetitorsQuestionsDTO()));

        competitors.forEach(competitor -> {
            List<CompetitorStandardQuestion> standardQuestions = competitorStandardQuestionRepository
                    .findAllByCompetitorAndSurvey(competitor, survey);
            List<CompetitorOpenQuestion> openQuestions = competitorOpenQuestionRepository
                    .findAllByCompetitorAndSurvey(competitor, survey);
            SectionEnum.getSections()
                    .forEach(sectionName -> {
                        Set<StandardQuestionDTO> standardDTO = generateSectionStandardQuestionDTOs(
                                new HashSet<>(standardQuestions),
                                sectionName
                        );
                        Set<OpenQuestionDTO> openDTO = openQuestions
                                .stream()
                                .filter(question -> question.getSection().getSectionName() == sectionName)
                                .map(openQuestionMapper::competitorOpenQuestionToOpenQuestionDTO)
                                .collect(Collectors.toSet());
                        competitorsQuestions
                                .get(sectionName)
                                .getCompetitorsQuestions()
                                .put(competitor.getID(), buildProductQuestionsDTO(standardDTO, openDTO));
                    });
        });
        return competitorsQuestions;
    }

    private Set<StandardQuestionDTO> generateSectionStandardQuestionDTOs(
            Set<? extends ProductStandardQuestion> productStandardQuestions,
            SectionEnum sectionName) {

        return productStandardQuestions
                .stream()
                .filter(question -> question.getKpiQuestion().getSection().getSectionName() == sectionName)
                .map(standardQuestionMapper::standardQuestionToStandardQuestionDTO)
                .collect(Collectors.toSet());
    }


    private SurveyQuestionDTO buildSurveyQuestionDTO(Map<SectionEnum, ProductQuestionsDTO> productQuestions,
                                                     Map<SectionEnum, CompetitorsQuestionsDTO> competitorsQuestions) {

        return new SurveyQuestionDTO(productQuestions, competitorsQuestions);
    }

    private ProductQuestionsDTO buildProductQuestionsDTO(Set<StandardQuestionDTO> productStandardQuestions,
                                                         Set<OpenQuestionDTO> productOpenQuestions) {

        return new ProductQuestionsDTO(productStandardQuestions, productOpenQuestions);
    }
}
