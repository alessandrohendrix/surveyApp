package com.surveyapp.survey.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public abstract class BasePacksize extends BaseEntity{

    @Column(name="amount")
    @NotBlank
    @Min(value = 1)
    int amount;

    @Column(name = "type")
    @NotBlank
    String type;

    @Column(name="weight")
    @NotBlank
    @Min(value = 0l)
    double weight;

    @Column(name = "measure")
    @NotBlank
    String measure;

    @Column(name = "volume")
    @EqualsAndHashCode.Exclude
    private boolean volume;
}
