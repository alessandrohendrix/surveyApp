package com.surveyapp.survey.domain.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntityDTO implements Serializable {

    @EqualsAndHashCode.Exclude
    private static final long serialVersionUID = 1L;
    @EqualsAndHashCode.Exclude
    private Integer ID;
}
