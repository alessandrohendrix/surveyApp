package com.surveyapp.survey.domain.entities.survey;

import com.surveyapp.survey.domain.entities.product.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ProductOpenQuestion extends Question {

}
