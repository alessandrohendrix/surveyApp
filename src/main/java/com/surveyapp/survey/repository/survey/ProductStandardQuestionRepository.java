package com.surveyapp.survey.repository.survey;

import com.surveyapp.survey.domain.entities.survey.ProductStandardQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStandardQuestionRepository extends JpaRepository<ProductStandardQuestion, Integer> {
}
