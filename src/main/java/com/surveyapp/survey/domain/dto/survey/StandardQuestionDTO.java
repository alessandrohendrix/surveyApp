package com.surveyapp.survey.domain.dto.survey;

import com.surveyapp.survey.domain.entities.survey.KPIQuestion;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardQuestionDTO extends BaseQuestionDTO {

    @NotNull
    private KPIQuestion kpiQuestion;
}
