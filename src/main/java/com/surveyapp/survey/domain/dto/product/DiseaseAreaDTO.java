package com.surveyapp.survey.domain.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class DiseaseAreaDTO implements Serializable {

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private final long serialVersionUID = 1L;
    @NotBlank
    private String name;
    @EqualsAndHashCode.Exclude
    private int ID;
}
