package com.surveyapp.survey.domain.entities.survey;

import com.surveyapp.survey.domain.entities.product.Competitor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "competitor_standard_question")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CompetitorStandardQuestion extends Question {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competitor_id")
    @EqualsAndHashCode.Exclude
    private Competitor competitor;
}
