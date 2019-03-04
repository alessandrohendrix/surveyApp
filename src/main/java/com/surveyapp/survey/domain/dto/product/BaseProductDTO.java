package com.surveyapp.survey.domain.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Setter
@Getter
public abstract class BaseProductDTO implements Serializable {

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private final long serialVersionUID = 1L;
    @EqualsAndHashCode.Exclude
    private int ID;
    @NotBlank
    @Size(min=1)
    private String name;
    @NotBlank
    @Size(min=1)
    private String molecule;
    @NotBlank
    @Size(min=1)
    private String productClass;
    @NotBlank
    @Size(min=1)
    private String indication;
    @EqualsAndHashCode.Exclude
    private boolean published;
    @EqualsAndHashCode.Exclude
    private boolean retired;
    @EqualsAndHashCode.Exclude
    private String productLogo;
}
