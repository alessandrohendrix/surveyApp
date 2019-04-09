package com.surveyapp.survey.service.survey;

import com.surveyapp.survey.domain.dto.survey.SurveyDTO;
import com.surveyapp.survey.domain.dto.survey.SurveyInfoDTO;
import com.surveyapp.survey.domain.entities.survey.Survey;


import java.util.Set;

public interface SurveySerializerService {

    SurveyDTO generateSurveyCreationDTO(Survey survey);

    SurveyInfoDTO generateSurveyInfoDTO(Survey survey);

    Set<SurveyInfoDTO> generateSurveyInfoDTOs(Set<Survey> surveys);
}
