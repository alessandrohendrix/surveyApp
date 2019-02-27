package com.surveyapp.survey.domain.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DiseaseAreaDTO implements Serializable {

    @EqualsAndHashCode.Exclude
    private final long serialVersionUID = 1L;
    @NotBlank
    private String name;
    @EqualsAndHashCode.Exclude
    private int ID;
}
