package com.surveyapp.survey.mapper.survey;

import com.surveyapp.survey.domain.dto.survey.OpenQuestionDTO;
import com.surveyapp.survey.domain.entities.survey.CompetitorOpenQuestion;
import com.surveyapp.survey.domain.entities.survey.ProductOpenQuestion;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Set;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
@Component
public interface OpenQuestionMapper {

    ProductOpenQuestion openQuestionDTOToProductOpenQuestion(OpenQuestionDTO openQuestionDTO);

    OpenQuestionDTO productOpenQuestionToOpenQuestionDTO(ProductOpenQuestion productOpenQuestion);

    CompetitorOpenQuestion openQuestionDTOToCompetitorOpenQuestion(OpenQuestionDTO openQuestionDTO);

    OpenQuestionDTO competitorOpenQuestionToOpenQuestionDTO(CompetitorOpenQuestion competitorOpenQuestion);

    @IterableMapping(elementTargetType = OpenQuestionDTO.class)
    Set<OpenQuestionDTO> openQuestionsToOpenQuestionDTOs(Set<ProductOpenQuestion> productOpenQuestions);

    @IterableMapping(elementTargetType = ProductOpenQuestion.class)
    Set<ProductOpenQuestion> openQuestionDTOsToOpenQuestions(Set<OpenQuestionDTO> openQuestionDTO);

    @IterableMapping(elementTargetType = OpenQuestionDTO.class)
    Set<OpenQuestionDTO> competitorOpenQuestionsToOpenQuestionDTOs(Set<CompetitorOpenQuestion> competitorOpenQuestions);

    @IterableMapping(elementTargetType = CompetitorOpenQuestion.class)
    Set<CompetitorOpenQuestion> openQuestionDTOsToCompetitOropenQuestions(Set<OpenQuestionDTO> openQuestionDTOs);
}
