package com.surveyapp.survey.domain.dto;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class CompetitorDTO extends BaseProductDTO{

    @EqualsAndHashCode.Exclude
    private Set<DiseaseAreaDTO> diseaseAreas;
    @EqualsAndHashCode.Exclude
    private Set<PacksizeCompetitorDTO> packsizes;

    /** public Set<DiseaseAreaDTO> getDiseaseAreas() {
        return diseaseAreas;
    }

    public void setDiseaseAreas(Set<DiseaseAreaDTO> diseaseAreas) {
        this.diseaseAreas = diseaseAreas;
    }

    public Set<PacksizeCompetitorDTO> getPacksizes() {
        return packsizes;
    }

    public void setPacksizes(Set<PacksizeCompetitorDTO> packsizes) {
        this.packsizes = packsizes;
    }

    public CompetitorDTO() {
    } **/
}
