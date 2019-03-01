package com.surveyapp.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.surveyapp.survey.domain.entities.product.Competitor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitorRepository extends JpaRepository<Competitor, Integer> {
}
