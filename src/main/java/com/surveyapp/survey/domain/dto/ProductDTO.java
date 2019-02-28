package com.surveyapp.survey.domain.dto;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class ProductDTO extends BaseProductDTO{

    @EqualsAndHashCode.Exclude
    private Set<DiseaseAreaDTO> diseaseAreas;
    @EqualsAndHashCode.Exclude
    private Set<PacksizeProductDTO> packsizes;
    @EqualsAndHashCode.Exclude
    private Set<CompetitorDTO> competitors;

    /** public ProductDTO() {
    }

    public Set<DiseaseAreaDTO> getDiseaseAreas() {
        return diseaseAreas;
    }

    public void setDiseaseAreas(Set<DiseaseAreaDTO> diseaseAreas) {
        this.diseaseAreas = diseaseAreas;
    }

    public Set<PacksizeProductDTO> getPacksizes() {
        return packsizes;
    }

    public void setPacksizes(Set<PacksizeProductDTO> packsizes) {
        this.packsizes = packsizes;
    }

    public Set<CompetitorDTO> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(Set<CompetitorDTO> competitors) {
        this.competitors = competitors;
    } **/
}
