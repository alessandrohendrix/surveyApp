package com.surveyapp.survey.service.survey;

import com.surveyapp.survey.domain.dto.survey.SurveyCreationDTO;
import com.surveyapp.survey.domain.dto.survey.SurveyInfoDTO;
import com.surveyapp.survey.domain.entities.survey.Survey;


import java.util.Set;

public interface SurveySerializerService {

    SurveyCreationDTO generateSurveyCreationDTO(Survey survey);

    SurveyInfoDTO generateSurveyInfoDTO(Survey survey);

    Set<SurveyInfoDTO> generateSurveyInfoDTOs(Set<Survey> surveys);

    Survey generateSurvey(SurveyCreationDTO surveyCreationDTO);
}
