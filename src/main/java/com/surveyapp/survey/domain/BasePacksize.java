package com.surveyapp.survey.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class BasePacksize extends BaseEntity{

    @Column(name = "Packsize")
    private String packsize;
    @Column(name = "Weight")
    private String weight;
    @Column(name = "Volume")
    private boolean volume;
}
