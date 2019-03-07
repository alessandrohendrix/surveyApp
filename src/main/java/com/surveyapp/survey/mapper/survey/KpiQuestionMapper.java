package com.surveyapp.survey.mapper.survey;

import com.surveyapp.survey.domain.dto.survey.KPIQuestionDTO;
import com.surveyapp.survey.domain.dto.survey.KpiQuestionIdDTO;
import com.surveyapp.survey.domain.entities.survey.KPIQuestion;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface KpiQuestionMapper {

    KPIQuestionDTO kpiQuestionToKpiQuestionDTO(KPIQuestion kpiQuestion);

    @IterableMapping(elementTargetType = KPIQuestionDTO.class)
    List<KPIQuestionDTO> kpiQuestionsToKpiQuestionDTOs(List<KPIQuestion> kpiQuestions);


    KpiQuestionIdDTO kpiQuestionToKPIIdDTO(KPIQuestion kpiQuestion);

    KPIQuestion kpiQuestionIdDTOToKPIQuestion(KpiQuestionIdDTO kpiQuestionIdDTO);

    @IterableMapping(elementTargetType = KpiQuestionIdDTO.class)
    List<KpiQuestionIdDTO> kpiQuestionsToKpiQuestionIdDTOs(List<KPIQuestion> kpiQuestions);

}
