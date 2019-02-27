package com.surveyapp.survey.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PackMeasure")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PackMeasure extends BaseEntity {

    private String measure;
}
