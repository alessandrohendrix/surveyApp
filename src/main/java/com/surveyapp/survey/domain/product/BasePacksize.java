package com.surveyapp.survey.domain.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public abstract class BasePacksize extends BaseEntity{

    @Column(name="Amount")
    @NotBlank
    @Min(value = 1)
    private int amount;

    @Column(name = "Type")
    @NotBlank
    private String type;

    @Column(name="Weight")
    @NotBlank
    @Min(value = 0l)
    private double weight;

    @Column(name = "Measure")
    @NotBlank
    private String measure;

    @Column(name = "Volume")
    @EqualsAndHashCode.Exclude
    private boolean volume;
}
