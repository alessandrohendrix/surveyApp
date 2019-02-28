package com.surveyapp.survey.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public abstract class PacksizeDTO implements Serializable {

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private final long serialVersionUID = 1L;

    @EqualsAndHashCode.Exclude
    private int ID;

    @NotBlank
    @Min(value = 1)
    private int amount;

    @NotBlank
    private String type;

    @NotBlank
    @Min(value = 0l)
    private double weight;

    @NotBlank
    private String measure;

    @NotBlank
    @EqualsAndHashCode.Exclude
    private boolean volume;
}
