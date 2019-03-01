package com.surveyapp.survey.repository;

import com.surveyapp.survey.domain.entities.survey.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
}
