package com.example.SerhalAndSerhal.Product;

import com.example.SerhalAndSerhal.Product.dto.ProductRequest;
import com.example.SerhalAndSerhal.Product.dto.ProductResponse;

public class ProductMapper {

    public static Product mapToProduct(ProductRequest productRequest){
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .brand(productRequest.getBrand())
                .build();
    }

    public static ProductResponse mapToProductRequest(Product product){
        return ProductResponse.builder()
              .id(product.getId())
              .name(product.getName())
              .description(product.getDescription())
              .price(product.getPrice())
              .build();
    }
}
