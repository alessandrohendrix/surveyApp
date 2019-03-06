package com.surveyapp.survey.mapper.survey;

import com.surveyapp.survey.domain.dto.survey.SurveyInfoDTO;
import com.surveyapp.survey.domain.entities.survey.Survey;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SurveyMapper {

    SurveyInfoDTO surveyToSurveyInfoDTO(Survey survey);

    Survey surveyInfoDTOToSurvey(SurveyInfoDTO surveyInfoDTO);

    @IterableMapping(elementTargetType = SurveyInfoDTO.class)
    Set<SurveyInfoDTO> surveysToSurveyInfoDTOs(Set<Survey> surveys);

    Set<Survey> surveyInfoDTOsToSurvey(Set<SurveyInfoDTO> surveyInfoDTOs);
}
