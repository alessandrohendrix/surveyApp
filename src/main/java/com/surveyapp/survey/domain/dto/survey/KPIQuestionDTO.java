package com.surveyapp.survey.domain.dto.survey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KPIQuestionDTO extends KpiQuestionIdDTO{

    private String question;
    private String details;
    private String answerFormat;
}
