package com.surveyapp.survey.domain.entities.survey;

import com.surveyapp.survey.domain.entities.product.BaseEntity;
import com.surveyapp.survey.domain.entities.product.PackMeasure;
import com.surveyapp.survey.domain.entities.product.PackType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Question extends BaseEntity {

    @NotNull
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id", referencedColumnName = "ID")
    private Survey survey;

    @NotBlank
    @NotNull
    private String diseaseArea;

    @NotBlank
    @NotNull
    @Min(1)
    private int packAmount;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pack_type", referencedColumnName = "ID")
    private PackType type;

    @NotBlank
    @NotNull
    private double packWeight;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pack_measure", referencedColumnName = "ID")
    private PackMeasure measure;

    @NotBlank
    @NotNull
    @Min(1)
    private int questionRow;

    @NotBlank
    @NotNull
    private String description;

}
