package com.surveyapp.survey.utility.mappers;

import com.surveyapp.survey.domain.Competitor;
import com.surveyapp.survey.domain.dto.CompetitorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(uses = {DiseaseAreaMapper.class, CompetitorPacksizeMapper.class})
public interface CompetitorMapper {

    CompetitorMapper INSTANCE = Mappers.getMapper(CompetitorMapper.class);

    CompetitorDTO competitorToCompetitorDTO(Competitor competitor);

    Competitor competitorDTOToCompetitor(CompetitorDTO competitorDTO);

    Set<CompetitorDTO> competitorsToCompetitorDTOs(Set<Competitor> competitors);

    Set<Competitor> competitorDTOsToCompetitors(Set<CompetitorDTO> competitorDTOs);
}
