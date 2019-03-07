package com.surveyapp.survey.domain.entities.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseProduct extends BaseEntity {

    @Column(name = "Name")
    private String name;

    @Column(name = "Molecule")
    private String molecule;

    @Column(name = "Class")
    private String productClass;

    @Column(name = "Indication")
  
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

}
