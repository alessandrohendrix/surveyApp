package com.surveyapp.survey.domain.entities.survey;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.surveyapp.survey.domain.entities.product.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class BaseQuestion extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "section_id", referencedColumnName = "ID")
    private Section section;
    private String question;

    @EqualsAndHashCode.Exclude
    private String details;
    private String answetrFormat;
    @JsonIgnore
    @OneToMany(
            mappedBy = "baseQuestion",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<BaseAnswer> baseAnswers;

}
