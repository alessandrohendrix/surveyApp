package com.surveyapp.survey.utility.mappers;

import com.surveyapp.survey.domain.DiseaseArea;
import com.surveyapp.survey.domain.dto.DiseaseAreaDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface DiseaseAreaMapper {

    DiseaseAreaMapper INSTANCE = Mappers.getMapper(DiseaseAreaMapper.class);

    DiseaseAreaDTO diseaseAreaToDiseaseAreaDTO(DiseaseArea diseaseArea);

    @IterableMapping(elementTargetType = DiseaseAreaDTO.class)
    Set<DiseaseAreaDTO> diseaseAreasToDiseaseAreaDTOs(Set<DiseaseArea> diseaseAreas);

    @IterableMapping(elementTargetType = DiseaseArea.class)
    Set<DiseaseArea> diseaseAreasDTOsToDiseaseAreas(Set<DiseaseAreaDTO> diseaseAreaDTOSet);
}
