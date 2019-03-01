package com.surveyapp.survey.service;

import com.surveyapp.survey.domain.product.BaseProduct;
import com.surveyapp.survey.domain.dto.product.BaseProductDTO;
import com.surveyapp.survey.utility.ByteToBase64Converter;

import java.util.Iterator;
import java.util.Set;
import java.util.function.BiConsumer;

public interface BaseProductService {

    default void setProductDTOImg(BaseProduct baseProduct, BaseProductDTO baseProductDTO) {
        baseProductDTO.setProductLogo(ByteToBase64Converter.convertToBase64(baseProduct.getLogo()));
    }

    default void setProductImg(BaseProduct baseProduct, BaseProductDTO baseProductDTO) {
        baseProduct.setLogo(ByteToBase64Converter.convertToByte(baseProductDTO.getProductLogo()));
    }

    default void setProductImgs(Set<? extends BaseProduct> baseProducts, Set<? extends BaseProductDTO> baseProductDTOs,
                                   BiConsumer<BaseProduct, BaseProductDTO> consumer) {

        Iterator<? extends BaseProduct> baseProductIterator = baseProducts.iterator();
        Iterator<? extends BaseProductDTO> baseProductDTOIterator = baseProductDTOs.iterator();
        while(baseProductIterator.hasNext() && baseProductDTOIterator.hasNext()) {
            consumer.accept(baseProductIterator.next(), baseProductDTOIterator.next());
        }
    }
}
