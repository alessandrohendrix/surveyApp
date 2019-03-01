package com.surveyapp.survey.utility.mappers;

import com.surveyapp.survey.domain.entities.product.Packsize;
import com.surveyapp.survey.domain.dto.product.PacksizeDTO;
import com.surveyapp.survey.domain.dto.product.PacksizeProductDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

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
