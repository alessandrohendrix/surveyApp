package com.surveyapp.survey.domain.dto.survey;

import com.surveyapp.survey.domain.entities.survey.CustomAnswer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OpenQuestionDTO extends BaseQuestionDTO {

    private Set<CustomAnswer> customAnswers;

    @NotBlank
    @NotNull
    private String description;

    @NotBlank
    @NotNull
    private String answerType;
}
