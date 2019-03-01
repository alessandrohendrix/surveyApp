package com.surveyapp.survey.repository;

import com.surveyapp.survey.domain.entities.product.Packsize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPacksizeRepository extends JpaRepository<Packsize, Integer> {
}
