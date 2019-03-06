package com.surveyapp.survey.service.survey.impl;

import com.surveyapp.survey.domain.dto.survey.KPIQuestionDTO;
import com.surveyapp.survey.domain.dto.survey.SurveyCreationDTO;
import com.surveyapp.survey.domain.dto.survey.SurveyInfoDTO;
import com.surveyapp.survey.domain.dto.survey.SurveyQuestionDTO;
import com.surveyapp.survey.domain.entities.survey.Enum.SectionEnum;
import com.surveyapp.survey.domain.entities.survey.KPIQuestion;
import com.surveyapp.survey.domain.entities.survey.Survey;
import com.surveyapp.survey.mapper.survey.KpiQuestionMapper;
import com.surveyapp.survey.mapper.survey.SurveyMapper;
import com.surveyapp.survey.repository.survey.KpiQuestionRepository;
import com.surveyapp.survey.service.survey.QuestionSerializerService;
import com.surveyapp.survey.service.survey.SurveySerializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SurveySerializerServiceImpl implements SurveySerializerService {

    private final QuestionSerializerService questionSerializerService;
    private final SurveyMapper surveyMapper;
    private final KpiQuestionMapper kpiQuestionMapper;
    private final KpiQuestionRepository kpiQuestionRepository;

    @Autowired
    public SurveySerializerServiceImpl(
            QuestionSerializerService questionSerializerService,
            SurveyMapper surveyMapper,
            KpiQuestionMapper kpiQuestionMapper,
            KpiQuestionRepository kpiQuestionRepository) {

        this.questionSerializerService = questionSerializerService;
        this.surveyMapper = surveyMapper;
        this.kpiQuestionMapper = kpiQuestionMapper;
        this.kpiQuestionRepository = kpiQuestionRepository;
    }

    @Override
    public SurveyCreationDTO generateSurveyCreationDTO(Survey survey) {
        SurveyInfoDTO surveyInfoDTO = generateSurveyInfoDTO(survey);
        SurveyQuestionDTO surveyQuestionDTO = questionSerializerService.aggregateQuestions(survey);
        List<KPIQuestion> kpiQuestions = kpiQuestionRepository.findAll();
        Map<SectionEnum, List<KPIQuestionDTO>> kpiQuesrionsSections = aggregateKPIQuestionsSections(kpiQuestions);
        return new SurveyCreationDTO(surveyInfoDTO, surveyQuestionDTO, kpiQuesrionsSections);
    }

    @Override
    public SurveyInfoDTO generateSurveyInfoDTO(Survey survey) {
        return surveyMapper.surveyToSurveyInfoDTO(survey);
    }

    @Override
    public Set<SurveyInfoDTO> generateSurveyInfoDTOs(Set<Survey> surveys) {
        return surveyMapper.surveysToSurveyInfoDTOs(surveys);
    }

    @Override
    public Survey generateSurvey(SurveyCreationDTO surveyCreationDTO) {
        return null;
    }

    private Map<SectionEnum, List<KPIQuestionDTO>> aggregateKPIQuestionsSections(List<KPIQuestion> kpiQuestions) {
        Map<SectionEnum, List<KPIQuestionDTO>> kpiQuestionsMap = new HashMap<>();
        SectionEnum.getSections().forEach(section -> {
            List<KPIQuestionDTO> sectionKPIQuestions = kpiQuestions
                    .stream()
                    .filter(question -> question.getSection().getSectionName() == section)
                    .map(kpiQuestionMapper::kpiQuestionToKpiQuestionDTO)
                    .collect(Collectors.toList());
            kpiQuestionsMap.put(section, sectionKPIQuestions);
        });
        return kpiQuestionsMap;
    }
}
