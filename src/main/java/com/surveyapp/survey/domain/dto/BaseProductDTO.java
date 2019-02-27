package com.surveyapp.survey.domain.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public abstract class BaseProductDTO implements Serializable {

    @EqualsAndHashCode.Exclude
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

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMolecule() {
        return molecule;
    }

    public void setMolecule(String molecule) {
        this.molecule = molecule;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    public String getProductLogo() {
        return productLogo;
    }

    public void setProductLogo(String productLogo) {
        this.productLogo = productLogo;
    }
}
