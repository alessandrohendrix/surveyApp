package com.surveyapp.survey.domain.dto.survey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SurveyCreationDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer productID;
    private SurveyInfoDTO surveyInfoDTO;
    private SurveyQuestionDTO surveyQuestionDTO;
}
