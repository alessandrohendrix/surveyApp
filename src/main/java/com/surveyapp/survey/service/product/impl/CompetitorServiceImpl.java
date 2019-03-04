package com.surveyapp.survey.service.product.impl;

import com.surveyapp.survey.domain.entities.product.Competitor;
import com.surveyapp.survey.repository.product.CompetitorRepository;
import com.surveyapp.survey.service.product.CompetitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CompetitorServiceImpl implements CompetitorService {

    private final CompetitorRepository competitorRepository;

    @Autowired
    public CompetitorServiceImpl(CompetitorRepository competitorRepository) {
        this.competitorRepository = competitorRepository;
    }

    @Override
    public Set<Competitor> getCompetitors() {
        Set<Competitor> competitors = new HashSet<>();
        this.competitorRepository.findAll().iterator().forEachRemaining(competitors::add);
        return competitors;
    }

    @Override
    public Competitor findByID(Integer id) {
        return competitorRepository.findById(id).orElseThrow(() -> new RuntimeException("Competitor not found"));
    }

    @Override
    public Set<Competitor> saveCompetitors(Set<Competitor> competitors) {
        List<Competitor> savedCompetitors = this.competitorRepository.saveAll(competitors);
        return new HashSet<>(savedCompetitors);
    }

    @Override
    public Set<Competitor> updateCompetitors(Set<Competitor> competitors) {
        Set<Competitor> updatedCompetitors = this.saveCompetitors(competitors);
        return updatedCompetitors;
    }
}
