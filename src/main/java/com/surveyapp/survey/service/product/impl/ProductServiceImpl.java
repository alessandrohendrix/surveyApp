package com.surveyapp.survey.service.product.impl;

import com.surveyapp.survey.domain.entities.product.Product;
import com.surveyapp.survey.repository.product.ProductRepository;
import com.surveyapp.survey.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
        Product product =  productRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Product with id "+id+ " not found"));
        return product;
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
