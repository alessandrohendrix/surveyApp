package com.surveyapp.survey.domain.entities.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public abstract class BasePacksize extends BaseEntity{

    @Column(name="Amount")
    @Min(value = 1)
    private int amount;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pack_type", referencedColumnName = "ID")
    private PackType type;

    @Column(name="Weight")
    @Min(value = 0l)
    private double weight;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pack_measure", referencedColumnName = "ID")
    private PackMeasure measure;

    @Column(name = "Volume")
    @EqualsAndHashCode.Exclude
    private boolean volume;
}
