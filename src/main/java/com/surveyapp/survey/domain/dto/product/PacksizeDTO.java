package com.surveyapp.survey.domain.dto.product;

import com.surveyapp.survey.domain.dto.BaseEntityDTO;
import com.surveyapp.survey.domain.entities.product.PackMeasure;
import com.surveyapp.survey.domain.entities.product.PackType;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class PacksizeDTO extends BaseEntityDTO {

    @Min(value = 1)
    private int amount;

    @NotNull
    private PackType type;

    @Min(value = 0l)
    private double weight;

    @NotNull
    private PackMeasure measure;

    @EqualsAndHashCode.Exclude
    private boolean volume;
}
