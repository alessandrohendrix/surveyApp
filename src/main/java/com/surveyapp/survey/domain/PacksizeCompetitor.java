package com.surveyapp.survey.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "competitor_packsize")
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PacksizeCompetitor extends BasePacksize{

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Comp_ID")
    private Competitor competitor;

    public void setProduct(Competitor competitor) {
        this.competitor = competitor;
    }
}
