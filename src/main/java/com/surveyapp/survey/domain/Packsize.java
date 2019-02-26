package com.surveyapp.survey.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Table(name = "packsize")
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Packsize extends BasePacksize{

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Prod_ID", referencedColumnName = "ID")
    private Product product;

    public void setProduct(Product product) {
        this.product = product;
    }
}
