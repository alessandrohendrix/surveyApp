package com.surveyapp.survey.service.impl;

import com.surveyapp.survey.domain.Product;
import com.surveyapp.survey.repository.ProductPacksizeRepository;
import com.surveyapp.survey.repository.ProductRepository;
import com.surveyapp.survey.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Set<Product> getProducts() {
        Set<Product> products = new HashSet<>();
        productRepository.findAll().iterator().forEachRemaining(products::add);
        return products;
    }

    @Override
    public Product findByID(String id) {
        Optional<Product> product =  productRepository.findById(Integer.valueOf(id));
        product.orElseThrow(() -> new RuntimeException("Product with id "+id+ " not found"));
        return product.get();
    }

    @Override
    public Product saveProduct(Product product) {
        product.setPacksizeProduct();
        Product newProduct = productRepository.save(product);
        return newProduct;
    }

    @Override
    public Product updateProduct(Product product) {
        Product updated = this.productRepository.save(product);
        return updated;
    }
}
