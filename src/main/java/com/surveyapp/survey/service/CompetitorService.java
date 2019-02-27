package com.surveyapp.survey.service;

import com.surveyapp.survey.domain.BaseProduct;
import com.surveyapp.survey.domain.Competitor;
import com.surveyapp.survey.domain.Product;
import com.surveyapp.survey.domain.dto.BaseProductDTO;
import com.surveyapp.survey.domain.dto.CompetitorDTO;
import com.surveyapp.survey.domain.dto.ProductDTO;

import java.util.Iterator;
import java.util.Set;
import java.util.function.BiConsumer;

public interface CompetitorService extends BaseProductService{

    Set<Competitor> getCompetitors();

    Set<Competitor> saveCompetitors(Set<Competitor> competitors);

    Set<Competitor> updateCompetitors(Set<Competitor> competitors);

    Competitor findByID(Integer id);

}
