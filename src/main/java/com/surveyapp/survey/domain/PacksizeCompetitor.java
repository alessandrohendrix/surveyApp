package com.surveyapp.survey.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "competitor_packsize")
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class PacksizeCompetitor extends BasePacksize{

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "Comp_ID")
    private Competitor competitor;

    public void setProduct(Competitor competitor) {
        this.competitor = competitor;
    }
}
