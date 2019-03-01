package com.surveyapp.survey.domain.entities.survey;

import com.surveyapp.survey.domain.entities.product.BaseEntity;
import com.surveyapp.survey.domain.entities.product.Product;
import com.surveyapp.survey.utility.LocalDateTimeConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "survey")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Survey extends BaseEntity {

    @Column(name = "generated")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime generated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @EqualsAndHashCode.Exclude
    private Product product;

    @OneToMany(
            mappedBy = "survey",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Question> questions;

    @EqualsAndHashCode.Exclude
    private boolean published;

}