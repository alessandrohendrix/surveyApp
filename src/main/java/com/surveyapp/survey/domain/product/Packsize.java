package com.surveyapp.survey.domain.product;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Table(name = "packsize")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
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
