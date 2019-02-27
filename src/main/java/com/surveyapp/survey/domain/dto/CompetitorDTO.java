package com.surveyapp.survey.domain.dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CompetitorDTO extends BaseProductDTO{

    @EqualsAndHashCode.Exclude
    private Set<DiseaseAreaDTO> diseaseAreas;
    @EqualsAndHashCode.Exclude
    private Set<CompetitorPacksizeDTO> packsizes;

}
