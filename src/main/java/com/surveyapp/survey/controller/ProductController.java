package com.surveyapp.survey.controller;

import com.surveyapp.survey.security.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.surveyapp.survey.service.ProductService;
import com.surveyapp.survey.domain.Product;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private final ProductService productService;
    private final UserAuthService userAuthService;

    @Autowired
    public ProductController(ProductService productService, UserAuthService userAuthService) {
        this.productService = productService;
        this.userAuthService = userAuthService;
    }

    @GetMapping("/products")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> getProducts() {
        Set<Product> products = this.productService.getProducts();
        if(!userAuthService.isUserAdmin()) {
            Set<Product> filteredProducts = products
                    .stream()
                    .filter(product -> product.isPublished() && !product.isRetired())
                    .collect(Collectors.toSet());
            return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> findProductByID(@PathVariable String id) {
        try {
            Product product = this.productService.findByID(id);
            if(!userAuthService.isUserAdmin() && (!product.isPublished() || product.isRetired())) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }
            return new ResponseEntity<>(product, HttpStatus.OK);
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
