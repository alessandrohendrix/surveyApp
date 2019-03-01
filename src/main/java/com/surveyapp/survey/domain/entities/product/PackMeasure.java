package com.surveyapp.survey.domain.entities.product;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PackMeasure")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PackMeasure extends BaseEntity {

    private String measure;
}
