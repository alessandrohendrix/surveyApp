package com.surveyapp.survey.domain.dto.survey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompetitorsQuestionsDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    Map<Integer, ProductQuestionsDTO> competitorsQuestions = new HashMap<>();

}
