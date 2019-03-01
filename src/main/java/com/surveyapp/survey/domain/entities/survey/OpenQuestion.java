package com.surveyapp.survey.domain.entities.survey;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "openQuestion")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OpenQuestion extends Question {

    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "openQuestion",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<CustomAnswer> customAnswer;
}
