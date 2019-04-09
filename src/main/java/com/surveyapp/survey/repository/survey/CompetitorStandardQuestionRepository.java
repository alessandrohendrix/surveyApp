package com.surveyapp.survey.repository.survey;

import com.surveyapp.survey.domain.entities.product.Competitor;
import com.surveyapp.survey.domain.entities.survey.CompetitorStandardQuestion;
import com.surveyapp.survey.domain.entities.survey.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitorStandardQuestionRepository extends JpaRepository<CompetitorStandardQuestion, Integer> {

    List<CompetitorStandardQuestion> findAllByCompetitorAndSurvey(Competitor competitor, Survey survey);
}
