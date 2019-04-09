package com.surveyapp.survey.repository.product;

import com.surveyapp.survey.domain.entities.product.DiseaseArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseAreaRepository extends JpaRepository<DiseaseArea, Integer> {
}
