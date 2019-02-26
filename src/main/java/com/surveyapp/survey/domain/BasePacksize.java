package com.surveyapp.survey.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public abstract class BasePacksize extends BaseEntity{

    @Column(name = "Packsize")
    @NotBlank
    private String packsize;

    @Column(name = "Weight")
    @NotBlank
    private String weight;

    @Column(name = "Volume")
    @EqualsAndHashCode.Exclude
    private boolean volume;
}
