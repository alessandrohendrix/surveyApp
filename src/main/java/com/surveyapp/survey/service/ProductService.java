package com.surveyapp.survey.service;

import com.surveyapp.survey.domain.BaseProduct;
import com.surveyapp.survey.domain.Product;
import com.surveyapp.survey.domain.dto.BaseProductDTO;
import com.surveyapp.survey.domain.dto.ProductDTO;

import java.util.Iterator;
import java.util.Set;
import java.util.function.BiConsumer;

public interface ProductService extends BaseProductService {

    Set<Product> getProducts();

    Product findByID(String id);

    Product saveProduct(Product product);

    Product updateProduct(Product product);

}
