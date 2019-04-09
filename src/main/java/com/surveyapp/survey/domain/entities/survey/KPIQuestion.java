package com.surveyapp.survey.domain.entities.survey;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.surveyapp.survey.domain.entities.product.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "kpi_question")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class KPIQuestion extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "section_id", referencedColumnName = "ID")
    private Section section;

    @NotBlank
    private String question;

    @EqualsAndHashCode.Exclude
    private String details;

    @NotBlank
    private String answerFormat;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "KPIQuestion",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<KPIAnswer> KPIAnswers;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "kpiQuestion",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<ProductStandardQuestion> productStandardQuestions;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "kpiQuestion",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<CompetitorStandardQuestion> competitorStandardQuestions;

}
