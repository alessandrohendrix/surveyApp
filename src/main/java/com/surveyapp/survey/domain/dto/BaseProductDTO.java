package com.surveyapp.survey.domain.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public abstract class BaseProductDTO implements Serializable {

    @EqualsAndHashCode.Exclude
    private final long serialVersionUID = 1L;
    @EqualsAndHashCode.Exclude
    private int ID;
    private String name;
    private String molecule;
    private String productClass;
    private String indication;
    private boolean published;
    private boolean retired;
    @EqualsAndHashCode.Exclude
    private String productLogo;
}
