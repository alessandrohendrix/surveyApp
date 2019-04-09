package com.surveyapp.survey.repository.survey;

import com.surveyapp.survey.domain.entities.survey.KPIQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpiQuestionRepository extends JpaRepository<KPIQuestion, Integer> {
}
