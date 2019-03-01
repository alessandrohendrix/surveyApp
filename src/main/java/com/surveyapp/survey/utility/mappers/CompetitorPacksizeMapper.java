package com.surveyapp.survey.utility.mappers;

import com.surveyapp.survey.domain.product.PacksizeCompetitor;
import com.surveyapp.survey.domain.dto.product.PacksizeCompetitorDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CompetitorPacksizeMapper {

    // CompetitorPacksizeMapper INSTANCE = Mappers.getMapper(CompetitorPacksizeMapper.class);

    PacksizeCompetitorDTO packsizeToCompetitorPacksizeDTO(PacksizeCompetitor packsizeCompetitor);

    PacksizeCompetitor packsizeCompetitorDTO(PacksizeCompetitorDTO packsizeCompetitorDTO);

    @IterableMapping(elementTargetType = PacksizeCompetitorDTO.class)
    Set<PacksizeCompetitorDTO> packsizesToPacksizeDTOs(Set<PacksizeCompetitor> packsizesCompetitor);

    @IterableMapping(elementTargetType = PacksizeCompetitor.class)
    Set<PacksizeCompetitor> packsizeDTOsToPacksizes(Set<PacksizeCompetitorDTO> packsizeCompetitorDTOs);
}
