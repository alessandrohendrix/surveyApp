package com.surveyapp.survey.utility.mappers;

import com.surveyapp.survey.domain.Product;
import com.surveyapp.survey.domain.dto.ProductDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(
        uses = {DiseaseAreaMapper.class, ProductPacksizeMapper.class,
                CompetitorMapper.class},
        componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ProductMapper {

    ProductDTO productToProductDTO(Product product);

    Product productDTOToProduct(ProductDTO productDTO);

    @IterableMapping(elementTargetType = ProductDTO.class)
    Set<ProductDTO> productsToProductDTOs(Set<Product> products);

    @IterableMapping(elementTargetType = Product.class)
    Set<Product> productDTOsToProduct(Set<ProductDTO> productDTOs);
}
