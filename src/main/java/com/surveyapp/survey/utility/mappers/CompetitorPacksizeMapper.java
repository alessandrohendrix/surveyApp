package com.surveyapp.survey.utility.mappers;

import com.surveyapp.survey.domain.PacksizeCompetitor;
import com.surveyapp.survey.domain.dto.PacksizeCompetitorDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface CompetitorPacksizeMapper {

    CompetitorPacksizeMapper INSTANCE = Mappers.getMapper(CompetitorPacksizeMapper.class);

    PacksizeCompetitorDTO packsizeToCompetitorPacksizeDTO(PacksizeCompetitor packsizeCompetitor);

    PacksizeCompetitor packsizeCompetitorDTO(PacksizeCompetitorDTO packsizeCompetitorDTO);

    @IterableMapping(elementTargetType = PacksizeCompetitorDTO.class)
    Set<PacksizeCompetitorDTO> packsizesToPacksizeDTOs(Set<PacksizeCompetitor> packsizesCompetitor);

    @IterableMapping(elementTargetType = PacksizeCompetitor.class)
    Set<PacksizeCompetitor> packsizeDTOsToPacksizes(Set<PacksizeCompetitorDTO> packsizeCompetitorDTOs);
}
