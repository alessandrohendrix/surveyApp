package com.surveyapp.survey.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Table(name = "packsize")
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Packsize extends BasePacksize{

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "Prod_ID", referencedColumnName = "ID")
    private Product product;

    public void setProduct(Product product) {
        this.product = product;
    }
}
