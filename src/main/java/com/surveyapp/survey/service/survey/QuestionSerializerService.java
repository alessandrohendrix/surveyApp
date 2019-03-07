package com.surveyapp.survey.service.survey;

import com.surveyapp.survey.domain.dto.survey.SurveyQuestionDTO;
import com.surveyapp.survey.domain.entities.product.Competitor;
import com.surveyapp.survey.domain.entities.survey.Survey;

import java.util.Set;

public interface QuestionSerializerService {

    SurveyQuestionDTO aggregateQuestions(Survey survey, Set<Competitor> competitors);
}
