package com.surveyapp.survey.mapper.survey;

import com.surveyapp.survey.domain.dto.survey.OpenQuestionDTO;
import com.surveyapp.survey.domain.entities.survey.CompetitorOpenQuestion;
import com.surveyapp.survey.domain.entities.survey.ProductOpenQuestion;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OpenQuestionMapper {

    @InheritInverseConfiguration(name = "productOpenQuestionToOpenQuestionDTO")
    ProductOpenQuestion openQuestionDTOToProductOpenQuestion(OpenQuestionDTO openQuestionDTO);

    @Mappings({@Mapping(source = "productOpenQuestion.productOpenCustomAnswers", target = "customAnswers")})
    OpenQuestionDTO productOpenQuestionToOpenQuestionDTO(ProductOpenQuestion productOpenQuestion);

    @InheritInverseConfiguration(name = "competitorOpenQuestionToOpenQuestionDTO")
    CompetitorOpenQuestion openQuestionDTOToCompetitorOpenQuestion(OpenQuestionDTO openQuestionDTO);

    @Mappings({@Mapping(source = "competitorOpenQuestion.competitorOpenCustomAnswers", target = "customAnswers")})
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
