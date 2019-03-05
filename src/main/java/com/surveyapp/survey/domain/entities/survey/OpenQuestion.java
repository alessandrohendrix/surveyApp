package com.surveyapp.survey.domain.entities.survey;

import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public abstract class OpenQuestion extends Question{

    @NotNull
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "section", referencedColumnName = "ID")
    private Section section;

    @NotBlank
    private String answerType;
}
