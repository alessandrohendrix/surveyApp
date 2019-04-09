package com.surveyapp.survey.mapper.product;

import com.surveyapp.survey.domain.entities.product.DiseaseArea;
import com.surveyapp.survey.domain.dto.product.DiseaseAreaDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DiseaseAreaMapper {

    DiseaseAreaDTO diseaseAreaToDiseaseAreaDTO(DiseaseArea diseaseArea);

    @IterableMapping(elementTargetType = DiseaseAreaDTO.class)
    Set<DiseaseAreaDTO> diseaseAreasToDiseaseAreaDTOs(Set<DiseaseArea> diseaseAreas);

    @IterableMapping(elementTargetType = DiseaseArea.class)
    Set<DiseaseArea> diseaseAreasDTOsToDiseaseAreas(Set<DiseaseAreaDTO> diseaseAreaDTOSet);
}
