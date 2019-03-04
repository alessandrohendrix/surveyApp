package com.surveyapp.survey.service.product;

import com.surveyapp.survey.domain.entities.product.Competitor;

import java.util.Set;

public interface CompetitorService extends BaseProductService{

    Set<Competitor> getCompetitors();

    Set<Competitor> saveCompetitors(Set<Competitor> competitors);

    Set<Competitor> updateCompetitors(Set<Competitor> competitors);

    Competitor findByID(Integer id);

}
