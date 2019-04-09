package com.surveyapp.survey.domain.entities.survey;

import com.surveyapp.survey.domain.entities.survey.Enum.SectionEnum;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
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

    @Override
    public SectionEnum getSectionName() {
        return section.getSectionName();
    }
}
