package com.surveyapp.survey.mapper.product;

import com.surveyapp.survey.domain.entities.product.Competitor;
import com.surveyapp.survey.domain.dto.product.CompetitorDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(uses = {DiseaseAreaMapper.class, CompetitorPacksizeMapper.class},
        componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CompetitorMapper {

    CompetitorDTO competitorToCompetitorDTO(Competitor competitor);

    Competitor competitorDTOToCompetitor(CompetitorDTO competitorDTO);

    @IterableMapping(elementTargetType = CompetitorDTO.class)
    Set<CompetitorDTO> competitorsToCompetitorDTOs(Set<Competitor> competitors);

    @IterableMapping(elementTargetType = Competitor.class)
    Set<Competitor> competitorDTOsToCompetitors(Set<CompetitorDTO> competitorDTOs);
}
