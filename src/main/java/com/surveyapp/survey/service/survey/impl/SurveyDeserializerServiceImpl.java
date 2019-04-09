package com.surveyapp.survey.service.survey.impl;

import com.surveyapp.survey.domain.dto.survey.*;
import com.surveyapp.survey.domain.entities.product.Competitor;
import com.surveyapp.survey.domain.entities.product.Product;
import com.surveyapp.survey.domain.entities.survey.*;
import com.surveyapp.survey.domain.entities.survey.Enum.SectionEnum;
import com.surveyapp.survey.mapper.survey.SurveyMapper;
import com.surveyapp.survey.service.survey.QuestionDeserializerService;
import com.surveyapp.survey.service.survey.SectionService;
import com.surveyapp.survey.service.survey.SurveyDeserializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class SurveyDeserializerServiceImpl implements SurveyDeserializerService {

    private final QuestionDeserializerService questionDeserializerService;
    private final SurveyMapper surveyMapper;
    private final SectionService sectionService;

    @Autowired
    public SurveyDeserializerServiceImpl(
            QuestionDeserializerService questionDeserializerService,
            SurveyMapper surveyMapper,
            SectionService sectionService) {

        this.questionDeserializerService = questionDeserializerService;
        this.surveyMapper = surveyMapper;
        this.sectionService = sectionService;
}

    @Override
    public Survey deserializeSurveyDTO(SurveyCreationDTO surveyDTO) {
        Map<SectionEnum, Section> sectionsMap = sectionService.getSectionsMap();
        Survey survey = surveyMapper.surveyInfoDTOToSurvey(surveyDTO.getSurveyInfoDTO());
        Product product = new Product();
        product.setID(surveyDTO.getProductID());
        survey.setProduct(product);
        SurveyQuestionDTO surveyQuestionDTO = surveyDTO.getSurveyQuestionDTO();
        Set<ProductStandardQuestion> productStandardQuestions =
                aggregateStandardQuestion(surveyQuestionDTO.getSectionsProductQuestions(), survey);
        survey.setProductStandardQuestions(productStandardQuestions);
        return survey;
    }

    private Set<ProductStandardQuestion> aggregateStandardQuestion(
            Map<SectionEnum, ProductQuestionsDTO> sectionsProductQuestions, Survey survey) {

        Set<ProductStandardQuestion> standardQuestions = new HashSet<>();
        sectionsProductQuestions
                .entrySet()
                .forEach(entry -> standardQuestions.addAll(
                        questionDeserializerService
                                .deserializeProductStandardQuestion(survey, entry.getValue().getStandardQuestions()))
                );
        return standardQuestions;
    }

    private Set<ProductOpenQuestion> aggregateOpenQuestion(
            Map<SectionEnum, ProductQuestionsDTO> sectionsProductQuestions,
            Survey survey,
            Map<SectionEnum, Section> sectionsMap) {

        Set<ProductOpenQuestion> openQuestions = new HashSet<>();
        sectionsProductQuestions
                .entrySet()
                .forEach(entry -> {
                    Section section = sectionsMap.get(entry.getKey());
                    Set<ProductOpenQuestion> sectionOpenQuestions =
                            questionDeserializerService
                                    .deserializeProductOpenQuestion(
                                            survey,
                                            entry.getValue().getOpenQuestions(),
                                            section
                                    );
                });
        return openQuestions;
    }

    private Set<CompetitorStandardQuestion> aggregateCompetitorStandardQuestion(
            Map<SectionEnum, CompetitorsQuestionsDTO> sectionsCompetitorQuestions, Survey survey) {

        Set<CompetitorStandardQuestion> competitorStandardQuestions = new HashSet<>();
        sectionsCompetitorQuestions
                .entrySet()
                .forEach(outerEntry -> {
                    outerEntry
                            .getValue()
                            .getCompetitorsQuestions()
                            .entrySet()
                            .forEach(entry -> {
                                Competitor competitor = new Competitor();
                                competitor.setID(entry.getKey());
                                competitorStandardQuestions.addAll(
                                        questionDeserializerService
                                                .deserializeCompetitorStandardQuestions(survey,
                                                        entry.getValue().getStandardQuestions(),
                                                        competitor)
                                );
                            });
                });
        return competitorStandardQuestions;
    }

}
