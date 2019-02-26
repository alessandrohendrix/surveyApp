package com.surveyapp.survey.service;

import com.surveyapp.survey.domain.Competitor;

import java.util.Set;

public interface CompetitorService {

    Set<Competitor> getCompetitors();

    Set<Competitor> saveCompetitors(Set<Competitor> competitors);

    Set<Competitor> updateCompetitors(Set<Competitor> competitors);
}
