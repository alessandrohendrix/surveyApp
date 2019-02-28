package com.surveyapp.survey.utility.mappers;

import com.surveyapp.survey.domain.Packsize;
import com.surveyapp.survey.domain.dto.PacksizeDTO;
import com.surveyapp.survey.domain.dto.PacksizeProductDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductPacksizeMapper {

    PacksizeProductDTO packsizeToPacksizeDTO(Packsize packsize);

    Packsize packsizeDTOToPacksize(PacksizeDTO packsizeDTO);

    @IterableMapping(elementTargetType = PacksizeProductDTO.class)
    Set<PacksizeProductDTO> packsizesToPacksizeDTOs(Set<Packsize> packsizes);

    @IterableMapping(elementTargetType = Packsize.class)
    Set<Packsize> packsizeDTOsToPacksizes(Set<PacksizeProductDTO> packsizeDTOs);

}