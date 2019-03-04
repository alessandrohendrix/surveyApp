package com.surveyapp.survey.domain.entities.survey;

import com.surveyapp.survey.domain.entities.product.Competitor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "competitor_open_question")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CompetitorOpenQuestion extends Question{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competitor_id")
    @EqualsAndHashCode.Exclude
    private Competitor competitor;

    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "openQuestion",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<CompetitorOpenCustomAnswer> competitorOpenCustomAnswers;

    @EqualsAndHashCode.Exclude
    @NotNull
    @ManyToOne
    @JoinColumn(name = "section", referencedColumnName = "ID")
    private Section section;

    @NotBlank
    private String answerType;
}
