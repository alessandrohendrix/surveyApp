package com.surveyapp.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.surveyapp.survey.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
