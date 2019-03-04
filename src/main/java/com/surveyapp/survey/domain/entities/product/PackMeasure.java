package com.surveyapp.survey.domain.entities.product;

import com.surveyapp.survey.domain.entities.survey.CompetitorOpenQuestion;
import com.surveyapp.survey.domain.entities.survey.CompetitorStandardQuestion;
import com.surveyapp.survey.domain.entities.survey.ProductOpenQuestion;
import com.surveyapp.survey.domain.entities.survey.ProductStandardQuestion;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PackMeasure")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PackMeasure extends BaseEntity {

    private String measure;

    @OneToMany(
            mappedBy = "measure",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<Packsize> productPacksizes;

    @OneToMany(
            mappedBy = "measure",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<PacksizeCompetitor> competitorPacksizes;

    @OneToMany(
            mappedBy = "measure",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<ProductStandardQuestion> productStandardQuestions;

    @OneToMany(
            mappedBy = "measure",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<ProductOpenQuestion> productOpenQuestions;

    @OneToMany(
            mappedBy = "measure",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<CompetitorStandardQuestion> competitorStandardQuestions;

    @OneToMany(
            mappedBy = "measure",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<CompetitorOpenQuestion> competitorOpenQuestions;
}
