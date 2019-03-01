package com.surveyapp.survey.domain.product;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "diseaseAreas", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "diseaseAreas", fetch = FetchType.LAZY)
    private Set<Competitor> competitors = new HashSet<>();

    public DiseaseArea(String name) {
        this.name = name;
    }

}
