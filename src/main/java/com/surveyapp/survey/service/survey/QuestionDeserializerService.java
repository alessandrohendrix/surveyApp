package com.surveyapp.survey.service.survey;

import com.surveyapp.survey.domain.dto.survey.OpenQuestionDTO;
import com.surveyapp.survey.domain.dto.survey.StandardQuestionDTO;
import com.surveyapp.survey.domain.entities.product.Competitor;
import com.surveyapp.survey.domain.entities.survey.*;

import java.util.Set;

public interface QuestionDeserializerService {

    Set<ProductStandardQuestion> deserializeProductStandardQuestion(
            Survey survey,
            Set<StandardQuestionDTO> standardQuestions
    );

    Set<ProductOpenQuestion> deserializeProductOpenQuestion(Survey survey, Set<OpenQuestionDTO> openQuestions, Section section);

    Set<CompetitorStandardQuestion> deserializeCompetitorStandardQuestions(
            Survey survey,
            Set<StandardQuestionDTO> standardQuestions,
            Competitor competitor
    );

    Set<CompetitorOpenQuestion> deserializeCompetitorOpenQuestions(
            Survey survey,
            Set<OpenQuestionDTO> openQuestions,
            Competitor competitor,
            Section section
    );
}
