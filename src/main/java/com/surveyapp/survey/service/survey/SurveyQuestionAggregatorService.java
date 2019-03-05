package com.surveyapp.survey.service.survey;

import com.surveyapp.survey.domain.dto.survey.SurveyQuestionDTO;
import com.surveyapp.survey.domain.entities.survey.Survey;

public interface SurveyQuestionAggregatorService {

    SurveyQuestionDTO aggregateQuestions(Survey survey);
}
