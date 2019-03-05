package com.surveyapp.survey.domain.dto.survey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductQuestionsDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Set<StandardQuestionDTO> standardQuestions;
    private Set<OpenQuestionDTO> openQuestions;

}
