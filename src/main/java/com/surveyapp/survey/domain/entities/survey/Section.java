package com.surveyapp.survey.domain.entities.survey;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.surveyapp.survey.domain.entities.product.BaseEntity;
import com.surveyapp.survey.domain.entities.survey.Enum.SectionEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "section")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Section extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private SectionEnum sectionName;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(
            mappedBy = "section",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<KPIQuestion> KPIQuestions;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(
            mappedBy = "section",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<ProductOpenQuestion> productOpenQuestions;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(
            mappedBy = "section",
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    private Set<CompetitorOpenQuestion> competitorOpenQuestions;
}
