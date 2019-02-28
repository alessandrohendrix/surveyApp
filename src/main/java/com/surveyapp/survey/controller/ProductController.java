package com.surveyapp.survey.controller;

import com.surveyapp.survey.domain.dto.ProductDTO;
import com.surveyapp.survey.security.service.UserAuthService;
import com.surveyapp.survey.utility.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.surveyapp.survey.service.ProductService;
import com.surveyapp.survey.domain.Product;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private final ProductService productService;
    private final UserAuthService userAuthService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService,
                             UserAuthService userAuthService,
                             ProductMapper productMapper) {
        this.productService = productService;
        this.userAuthService = userAuthService;
        this.productMapper = productMapper;
    }

    @GetMapping("/products")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> getProducts() {
        Set<Product> products = this.productService.getProducts();
        Set<ProductDTO> productDTOs = productMapper.productsToProductDTOs(products);
        productService.setProductImgs(products, productDTOs, this.productService::setProductDTOImg);
        if(!userAuthService.isUserAdmin()) {
            Set<ProductDTO> filteredProducts = productDTOs
                    .stream()
                    .filter(product -> product.isPublished() && !product.isRetired())
                    .collect(Collectors.toSet());
            return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
        }
        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> getProductByID(@PathVariable String id) {
        try {
            Product product = this.productService.findByID(id);
            ProductDTO productDTO = productMapper.productToProductDTO(product);
            productService.setProductDTOImg(product, productDTO);
            if(!userAuthService.isUserAdmin() && (!product.isPublished() || product.isRetired())) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Product with id %s not found", id), e);
        }
    }

    @PostMapping("/products")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addNewProduct(@Valid @RequestBody ProductDTO productDTO) {
        try {
            Product newProduct = recreateProduct(productDTO);
            Product savedProduct = this.productService.saveProduct(newProduct);
            ProductDTO dto = createProductDTO(savedProduct);
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/products")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductDTO productDTO) {
        try {
            Product product = recreateProduct(productDTO);
            Product updatedProduct = this.productService.updateProduct(product);
            ProductDTO dto = createProductDTO(updatedProduct);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    private Product recreateProduct(ProductDTO productDTO) {
        Product product = productMapper.productDTOToProduct(productDTO);
        this.productService.setProductImg(product, productDTO);
        return product;
    }

    private ProductDTO createProductDTO(Product product) {
        ProductDTO dto = productMapper.productToProductDTO(product);
        this.productService.setProductDTOImg(product, dto);
        return dto;
    }
}
