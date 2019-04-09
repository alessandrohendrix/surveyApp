package com.surveyapp.survey.domain.dto.product;

import com.surveyapp.survey.domain.dto.BaseEntityDTO;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class DiseaseAreaDTO extends BaseEntityDTO {

    @NotBlank
    private String name;
}
