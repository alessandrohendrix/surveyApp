package com.surveyapp.survey.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode
public abstract class BaseProduct extends BaseEntity {

    @Column(name = "Name")
    @NotBlank
    @Size(min=1)
    private String name;

    @Column(name = "Molecule")
    @NotBlank
    @Size(min=1)
    private String molecule;

    @Column(name = "Class")
    @NotBlank
    @Size(min=1)
    private String productClass;

    @Column(name = "Indication")
    @NotBlank
    @Size(min=1)
    private String indication;

    @Column(name = "Logo", length = 100000)
    @Lob
    @EqualsAndHashCode.Exclude
    private byte[] logo;

    @Column(name = "Published")
    @EqualsAndHashCode.Exclude
    private boolean published;

    @Column(name = "Retired")
    @EqualsAndHashCode.Exclude
    private boolean retired;

    public BaseProduct(Integer ID, String name, String molecule) {
        this.ID = ID;
        this.name = name;
        this.molecule = molecule;
    }

    public BaseProduct(String name, String molecule, String productClass, String indication, boolean published, boolean retired) {
        this.name = name;
        this.molecule = molecule;
        this.productClass = productClass;
        this.indication = indication;
        this.published = published;
        this.retired = retired;
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

    public byte[] getLogo() {
        return logo;
    }

    public boolean isPublished() {
        return published;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMolecule(String molecule) {
        this.molecule = molecule;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }
}
