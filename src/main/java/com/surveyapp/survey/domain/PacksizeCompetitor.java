package com.surveyapp.survey.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "competitor_packsize")
@EqualsAndHashCode(callSuper = true)
@Getter
@NoArgsConstructor
public class PacksizeCompetitor extends BasePacksize{

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Comp_ID")
    private Competitor competitor;

    /**public PacksizeCompetitor() {
    }

     public Competitor getCompetitor() {
        return competitor;
    } **/

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }
}
