package com.surveyapp.survey.domain.dto.survey;

import com.surveyapp.survey.domain.entities.survey.Enum.SectionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SurveyQuestionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<SectionEnum, ProductQuestionsDTO> sectionsProductQuestions;
    private Map<SectionEnum, CompetitorsQuestionsDTO> sectionsCompetitorQuestions;
}
