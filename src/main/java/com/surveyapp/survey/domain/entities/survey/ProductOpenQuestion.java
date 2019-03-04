package com.surveyapp.survey.domain.entities.survey;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "product_open_question")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ProductOpenQuestion extends Question {

    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "openQuestion",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<ProductOpenCustomAnswer> productOpenCustomAnswers;

    @NotNull
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "section", referencedColumnName = "ID")
    private Section section;

    @NotBlank
    private String answerType;

}
