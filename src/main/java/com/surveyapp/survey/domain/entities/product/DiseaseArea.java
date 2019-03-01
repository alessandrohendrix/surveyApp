package com.surveyapp.survey.domain.entities.product;

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
    @ManyToMany(mappedBy = "diseaseAreas", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "diseaseAreas", fetch = FetchType.LAZY)
    private Set<Competitor> competitors = new HashSet<>();

    public DiseaseArea(String name) {
        this.name = name;
    }

}
