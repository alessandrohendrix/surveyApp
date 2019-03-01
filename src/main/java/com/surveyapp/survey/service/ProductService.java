package com.surveyapp.survey.service;

import com.surveyapp.survey.domain.entities.product.Product;

import java.util.Set;

public interface ProductService extends BaseProductService {

    Set<Product> getProducts();

    Product findByID(String id);

    Product saveProduct(Product product);

    Product updateProduct(Product product);

}
