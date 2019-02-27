package com.surveyapp.survey.domain.dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ProductDTO extends BaseProductDTO{

    @EqualsAndHashCode.Exclude
    private Set<DiseaseAreaDTO> diseaseAreas;
    @EqualsAndHashCode.Exclude
    private Set<ProductPacksizeDTO> packsizes;
    @EqualsAndHashCode.Exclude
    private Set<CompetitorDTO> competitors;

}
