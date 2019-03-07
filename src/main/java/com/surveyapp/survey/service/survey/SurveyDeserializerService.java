package com.surveyapp.survey.service.survey;

import com.surveyapp.survey.domain.dto.survey.SurveyCreationDTO;
import com.surveyapp.survey.domain.entities.survey.Survey;

public interface SurveyDeserializerService {

    Survey deserializeSurveyDTO(SurveyCreationDTO surveyDTO);
}
