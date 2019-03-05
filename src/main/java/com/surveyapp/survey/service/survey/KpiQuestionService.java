package com.surveyapp.survey.service.survey;

import com.surveyapp.survey.domain.entities.survey.KPIQuestion;

import java.util.Set;

public interface KpiQuestionService {

    Set<KPIQuestion> retrieveKPIQuestions();
}
