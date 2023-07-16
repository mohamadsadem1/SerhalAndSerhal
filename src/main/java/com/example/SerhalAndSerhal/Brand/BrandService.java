package com.example.SerhalAndSerhal.Brand;

import com.example.SerhalAndSerhal.Brand.DTO.BrandRequest;
import com.example.SerhalAndSerhal.Brand.DTO.BrandResponse;

import java.util.List;

public interface BrandService {
    BrandRequest createBrand(BrandRequest brandRequest);
    public BrandResponse updateBrandById(Long id,BrandRequest brandRequest);
    void deleteBrandById(Long id);

    BrandResponse getBrandById(Long id);
    BrandResponse getBrandByName(String name);
    List<BrandResponse> getAllBrands();
}
