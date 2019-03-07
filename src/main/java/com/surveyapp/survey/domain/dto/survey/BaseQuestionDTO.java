package com.surveyapp.survey.domain.dto.survey;

import com.surveyapp.survey.domain.dto.BaseEntityDTO;
import com.surveyapp.survey.domain.entities.product.PackMeasure;
import com.surveyapp.survey.domain.entities.product.PackType;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public abstract class BaseQuestionDTO extends BaseEntityDTO {


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
    @EqualsAndHashCode.Exclude
    private int questionRow;
}
