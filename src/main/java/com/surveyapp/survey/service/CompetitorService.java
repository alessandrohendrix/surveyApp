package com.surveyapp.survey.service;

import com.surveyapp.survey.domain.product.Competitor;

import java.util.Set;

public interface CompetitorService extends BaseProductService{

    Set<Competitor> getCompetitors();

    Set<Competitor> saveCompetitors(Set<Competitor> competitors);

    Set<Competitor> updateCompetitors(Set<Competitor> competitors);

    Competitor findByID(Integer id);

}
