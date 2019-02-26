package com.surveyapp.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.surveyapp.survey.service.ProductService;
import com.surveyapp.survey.domain.Product;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Set<Product> getProducts() {
        Set<Product> products = this.productService.getProducts();
        return products;
    }

    @GetMapping("/products/{id}")
    public Product findProductByID(@PathVariable String id) {
        try {
            return this.productService.findByID(id);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product with id %s not found", id), e);
        }
    }

    @PostMapping("/products")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addNewProduct(@RequestBody Product product) {
        Product newProduct = this.productService.saveProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/products")
    @PreAuthorize("hasRole('ADMIN')")
    public Product updateProduct(@RequestBody Product product) {
        Product updatedProduct = this.productService.saveProduct(product);
        return updatedProduct;
    }
}
