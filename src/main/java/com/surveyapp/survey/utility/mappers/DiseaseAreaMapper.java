package com.surveyapp.survey.utility.mappers;

import com.surveyapp.survey.domain.DiseaseArea;
import com.surveyapp.survey.domain.dto.DiseaseAreaDTO;
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
