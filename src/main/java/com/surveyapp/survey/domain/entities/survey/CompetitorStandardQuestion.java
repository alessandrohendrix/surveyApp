package com.surveyapp.survey.domain.entities.survey;

import com.surveyapp.survey.domain.entities.product.Competitor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CompetitorStandardQuestion extends Question {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competitor_id")
    @EqualsAndHashCode.Exclude
    private Competitor competitor;
}
