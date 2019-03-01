package com.surveyapp.survey.domain.entities.product;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PackType")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PackType extends BaseEntity{

    private String packType;
}
