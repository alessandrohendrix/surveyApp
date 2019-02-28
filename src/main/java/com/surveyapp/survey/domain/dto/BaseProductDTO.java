package com.surveyapp.survey.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Setter
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

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getMolecule() {
        return molecule;
    }

    public String getProductClass() {
        return productClass;
    }

    public String getIndication() {
        return indication;
    }

    public boolean isPublished() {
        return published;
    }

    public boolean isRetired() {
        return retired;
    }

    public String getProductLogo() {
        return productLogo;
    }
}
