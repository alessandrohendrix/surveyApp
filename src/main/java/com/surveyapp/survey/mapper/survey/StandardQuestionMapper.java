package com.surveyapp.survey.mapper.survey;

import com.surveyapp.survey.domain.dto.survey.StandardQuestionDTO;
import com.surveyapp.survey.domain.entities.survey.CompetitorStandardQuestion;
import com.surveyapp.survey.domain.entities.survey.ProductStandardQuestion;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Set;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
@Component
public interface StandardQuestionMapper {

    StandardQuestionDTO standardQuestionToStandardQuestionDTO(ProductStandardQuestion productStandardQuestion);

    ProductStandardQuestion standardQuestionDTOToStandardQuestion(StandardQuestionDTO standardQuestionDTO);

    StandardQuestionDTO competitorQuestionToStandardQuestionDTO(CompetitorStandardQuestion competitorStandardQuestion);

    CompetitorStandardQuestion competitorStandardQuestionToStandardQuestionDTO(StandardQuestionDTO standardQuestionDTO);

    @IterableMapping(elementTargetType = StandardQuestionDTO.class)
    Set<StandardQuestionDTO> standardQuestionsToStandardQuestionDTOs(Set<ProductStandardQuestion> productStandardQuestions);

    @IterableMapping(elementTargetType = ProductStandardQuestion.class)
    Set<ProductStandardQuestion> standardQuestionDTOsToStandardQuestions(Set<StandardQuestionDTO> standardQuestionDTO);

    @IterableMapping(elementTargetType = StandardQuestionDTO.class)
    Set<StandardQuestionDTO> competitorStandardQuestionsToStandardQuestionDTOs(Set<CompetitorStandardQuestion> competitorStandardQuestions);

    @IterableMapping(elementTargetType = CompetitorStandardQuestion.class)
    Set<CompetitorStandardQuestion> standardQuestionDTOsToCompetitorStandardQuestions(Set<StandardQuestionDTO> standardQuestionDTO);

}