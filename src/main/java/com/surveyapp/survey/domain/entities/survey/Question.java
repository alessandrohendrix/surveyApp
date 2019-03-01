package com.surveyapp.survey.domain.entities.survey;

import com.surveyapp.survey.domain.entities.product.BaseEntity;
import com.surveyapp.survey.domain.entities.product.PackMeasure;
import com.surveyapp.survey.domain.entities.product.PackType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Question extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id", referencedColumnName = "ID")
    private Survey survey;
    private String diseaseArea;
    private int packAmount;
    private PackType type;
    private double weight;
    private PackMeasure measure;
    private Section section;
    private int row;
    private String description;

}
