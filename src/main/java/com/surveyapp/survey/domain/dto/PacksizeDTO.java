package com.surveyapp.survey.domain.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public abstract class PacksizeDTO implements Serializable {

    @EqualsAndHashCode.Exclude
    private final long serialVersionUID = 1L;
    @EqualsAndHashCode.Exclude
    private int ID;
    private int amount;
    private String type;
    private double weight;
    private String measure;
    private boolean volume;
    @EqualsAndHashCode.Exclude
    private ProductDTO product;
}
