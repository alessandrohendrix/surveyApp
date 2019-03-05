package com.surveyapp.survey.domain.dto.survey;

import com.surveyapp.survey.domain.entities.product.PackMeasure;
import com.surveyapp.survey.domain.entities.product.PackType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class BaseQuestionDTO implements Serializable {

    private Integer ID;

    @NotBlank
    @NotNull
    private String diseaseArea;

    @NotBlank
    @NotNull
    @Min(1)
    private int packAmount;

    @NotNull
    private PackType type;

    @NotBlank
    @NotNull
    private double packWeight;

    @NotNull
    private PackMeasure measure;

    @NotBlank
    @NotNull
    @Min(1)
    private int questionRow;

    @NotBlank
    @NotNull
    private String description;
}
