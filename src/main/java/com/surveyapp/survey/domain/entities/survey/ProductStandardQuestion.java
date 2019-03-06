package com.surveyapp.survey.domain.entities.survey;

import com.surveyapp.survey.domain.entities.survey.Enum.SectionEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product_standard_question")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ProductStandardQuestion extends Question {

    @NotNull
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kpi_question", referencedColumnName = "ID")
    private KPIQuestion kpiQuestion;


    @Override
    public SectionEnum getSectionName() {
        return kpiQuestion.getSection().getSectionName();
    }
}
