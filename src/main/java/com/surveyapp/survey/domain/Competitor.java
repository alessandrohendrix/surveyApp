package com.surveyapp.survey.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "competitor")
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class Competitor extends BaseProduct {

    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "competitor_disease_area",
            joinColumns = @JoinColumn(name = "Competitor_ID"),
            inverseJoinColumns = @JoinColumn(name = "Disease_Area_Competitor_ID")
    )
    private Set<DiseaseArea> diseaseAreas = new HashSet<>();
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "competitor",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private Set<PacksizeCompetitor> packsizes = new HashSet<>();
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "competitors")
    private Set<Product> products = new HashSet<>();

    public Competitor(String name, String molecule, String productClass, String indication, boolean published, boolean retired) {
        super(name, molecule, productClass, indication, published, retired);
    }

    public void setPacksizeCompetitor() {
        this.packsizes.forEach(pack -> pack.setCompetitor(this));
    }

    /** public Competitor() {}

    public Set<DiseaseArea> getDiseaseAreas() {
        return diseaseAreas;
    }

    public void setDiseaseAreas(Set<DiseaseArea> diseaseAreas) {
        this.diseaseAreas = diseaseAreas;
    }

    public Set<PacksizeCompetitor> getPacksizes() {
        return packsizes;
    }

    public void setPacksizes(Set<PacksizeCompetitor> packsizes) {
        this.packsizes = packsizes;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    } **/
}
