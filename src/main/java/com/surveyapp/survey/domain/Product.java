package com.surveyapp.survey.domain;

import javax.persistence.*;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseProduct {

    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_disease_area",
            joinColumns = @JoinColumn(name = "Product_ID"),
            inverseJoinColumns = @JoinColumn(name = "Disease_Area_ID")
    )
    private Set<DiseaseArea> diseaseAreas = new HashSet<>();
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private Set<Packsize> packsizes = new HashSet<>();
    @EqualsAndHashCode.Exclude
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_competitor",
            joinColumns = @JoinColumn(name = "Product_Middle_ID"),
            inverseJoinColumns = @JoinColumn(name = "Competitor_Middle_ID")
    )
    private Set<Competitor> competitors = new HashSet<>();

    public Product(Integer ID, String name, String molecule) {
        super(ID, name, molecule);
    }

    public void setPacksizeProduct() {
        this.packsizes.forEach(packsize -> packsize.setProduct(this));
    }
    /** public Product() {}

    public Set<DiseaseArea> getDiseaseAreas() {
        return diseaseAreas;
    }

    public void setDiseaseAreas(Set<DiseaseArea> diseaseAreas) {
        this.diseaseAreas = diseaseAreas;
    }

    public Set<Packsize> getPacksizes() {
        return packsizes;
    }

    public void setPacksizes(Set<Packsize> packsizes) {
        this.packsizes = packsizes;
    }

    public Set<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(Set<Competitor> competitors) {
        this.competitors = competitors;
    } **/
}
