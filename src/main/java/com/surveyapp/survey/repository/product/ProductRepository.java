package com.surveyapp.survey.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import com.surveyapp.survey.domain.entities.product.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
