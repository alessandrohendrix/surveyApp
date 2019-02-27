package com.surveyapp.survey.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PackType")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PackType extends BaseEntity{

    private String packType;
}
