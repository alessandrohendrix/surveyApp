package com.surveyapp.survey.domain.dto.survey;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardQuestionDTO extends BaseQuestionDTO {

    @NotNull
    private KpiQuestionIdDTO kpiQuestionID;
}
