package com.surveyapp.survey.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "diseaseArea")
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class DiseaseArea extends BaseEntity{

    @Column(name = "Name")
    @NotBlank
    private String name;
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "diseaseAreas")
    private Set<Product> products = new HashSet<>();
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "diseaseAreas")
    private Set<Competitor> competitors = new HashSet<>();

    public DiseaseArea(String name) {
        this.name = name;
    }

    /** public DiseaseArea() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(Set<Competitor> competitors) {
        this.competitors = competitors;
    } **/
}
