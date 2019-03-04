package com.surveyapp.survey.domain.entities.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @NotBlank
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pack_type", referencedColumnName = "ID")
    private PackType type;

    @Column(name="Weight")
    @NotBlank
    @Min(value = 0l)
    private double weight;

    @NotBlank
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pack_measure", referencedColumnName = "ID")
    private PackMeasure measure;

    @Column(name = "Volume")
    @EqualsAndHashCode.Exclude
    private boolean volume;
}
