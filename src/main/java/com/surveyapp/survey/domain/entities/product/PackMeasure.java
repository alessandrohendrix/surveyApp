package com.surveyapp.survey.domain.entities.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.surveyapp.survey.domain.entities.survey.CompetitorOpenQuestion;
import com.surveyapp.survey.domain.entities.survey.CompetitorStandardQuestion;
import com.surveyapp.survey.domain.entities.survey.ProductOpenQuestion;
import com.surveyapp.survey.domain.entities.survey.ProductStandardQuestion;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PackMeasure")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PackMeasure extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String measure;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(
            mappedBy = "measure",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<Packsize> productPacksizes;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(
            mappedBy = "measure",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<PacksizeCompetitor> competitorPacksizes;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(
            mappedBy = "measure",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<ProductStandardQuestion> productStandardQuestions;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(
            mappedBy = "measure",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<ProductOpenQuestion> productOpenQuestions;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(
            mappedBy = "measure",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<CompetitorStandardQuestion> competitorStandardQuestions;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(
            mappedBy = "measure",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<CompetitorOpenQuestion> competitorOpenQuestions;
}
