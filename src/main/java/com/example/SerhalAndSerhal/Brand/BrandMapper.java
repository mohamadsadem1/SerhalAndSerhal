package com.example.SerhalAndSerhal.Brand;


import com.example.SerhalAndSerhal.Brand.DTO.BrandRequest;
import com.example.SerhalAndSerhal.Brand.DTO.BrandResponse;


public class BrandMapper {
    public static Brand mapToProduct(BrandRequest brandRequest){
        return Brand.builder()
                .name(brandRequest.getName())
                .build();
    }

    public static BrandResponse mapToProductResponse(Brand brand){


        return BrandResponse.builder()
                .id(brand.getId())
              .name(brand.getName())
              .build();
    }
}
