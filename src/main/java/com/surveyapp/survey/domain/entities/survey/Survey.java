package com.surveyapp.survey.domain.entities.survey;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.surveyapp.survey.domain.entities.product.BaseEntity;
import com.surveyapp.survey.domain.entities.product.Product;
import com.surveyapp.survey.utility.LocalDateTimeConverter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "survey")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Survey extends BaseEntity {

    @NotNull
    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @JsonIgnore
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @EqualsAndHashCode.Exclude
    private Product product;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "survey",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<ProductStandardQuestion> productStandardQuestions;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "survey",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<ProductOpenQuestion> productOpenQuestions;

    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "survey",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<CompetitorStandardQuestion> competitorStandardQuestions;

    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "survey",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<CompetitorOpenQuestion> competitorOpenQuestions;

    @EqualsAndHashCode.Exclude
    private boolean published;

    public Survey(@NotNull LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Survey(@NotNull LocalDateTime creationDate, Integer ID) {
        super(ID);
        this.creationDate = creationDate;
    }

}