package com.surveyapp.survey.domain.entities.product;

import com.surveyapp.survey.domain.entities.survey.CompetitorOpenQuestion;
import com.surveyapp.survey.domain.entities.survey.CompetitorStandardQuestion;
import com.surveyapp.survey.domain.entities.survey.ProductOpenQuestion;
import com.surveyapp.survey.domain.entities.survey.ProductStandardQuestion;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PackType")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PackType extends BaseEntity{

    private String packType;

    @OneToMany(
            mappedBy = "type",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<Packsize> productPacksizes;

    @OneToMany(
            mappedBy = "type",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<PacksizeCompetitor> competitorPacksizes;

    @OneToMany(
            mappedBy = "type",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<ProductStandardQuestion> productStandardQuestions;

    @OneToMany(
            mappedBy = "type",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<ProductOpenQuestion> productOpenQuestions;

    @OneToMany(
            mappedBy = "type",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<CompetitorStandardQuestion> competitorStandardQuestions;

    @OneToMany(
            mappedBy = "type",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<CompetitorOpenQuestion> competitorOpenQuestions;
}
