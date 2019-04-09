package com.surveyapp.survey.repository.survey;

import com.surveyapp.survey.domain.entities.product.Competitor;
import com.surveyapp.survey.domain.entities.survey.CompetitorOpenQuestion;
import com.surveyapp.survey.domain.entities.survey.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitorOpenQuestionRepository extends JpaRepository<CompetitorOpenQuestion, Integer> {

    List<CompetitorOpenQuestion> findAllByCompetitorAndSurvey(Competitor competitor, Survey survey);
}
