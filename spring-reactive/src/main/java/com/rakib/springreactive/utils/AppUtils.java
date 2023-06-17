package com.rakib.springreactive.utils;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.rakib.springreactive.dto.ProductDto;
import com.rakib.springreactive.entity.Product;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    private AppUtils() {
    }

    public static ProductDto entityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product dtoToEntity(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}
