package com.surveyapp.survey.utility.mappers;

import com.surveyapp.survey.domain.Competitor;
import com.surveyapp.survey.domain.dto.CompetitorDTO;
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