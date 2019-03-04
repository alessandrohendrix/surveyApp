package com.surveyapp.survey.service.survey;

import com.surveyapp.survey.domain.entities.survey.Survey;

import java.time.LocalDateTime;
import java.util.Set;

public interface SurveyService {

    Survey findProductMostRecentSurvey(Integer productID, boolean published);

    Survey findProductSurveyByCreationDate(Integer productID, LocalDateTime creationDate);

    Set<LocalDateTime> findProductSurveyCreationDates(Integer productID);
}
