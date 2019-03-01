package com.surveyapp.survey.domain.dto.product;

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
}
