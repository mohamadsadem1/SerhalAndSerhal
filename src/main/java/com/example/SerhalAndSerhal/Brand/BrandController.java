package com.example.SerhalAndSerhal.Brand;

import com.example.SerhalAndSerhal.Brand.DTO.BrandRequest;
import com.example.SerhalAndSerhal.Brand.DTO.BrandResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("api/Brand")
public class BrandController {

    private BrandServiceIMPL brandServiceIMPL;


    @GetMapping
    public ResponseEntity<List<BrandResponse>> getAllBrands() {

        return new ResponseEntity<>(brandServiceIMPL.getAllBrands(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<BrandRequest> createBrand(@RequestBody BrandRequest brandRequest) {
        brandServiceIMPL.createBrand(brandRequest);
        return new ResponseEntity<>(brandRequest, HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<BrandResponse> updateBrand(@PathVariable ("id") Long BrandId,
                                                       @RequestBody  BrandRequest brandRequest) {
     BrandResponse updatedBrand= brandServiceIMPL.updateBrandById(BrandId,brandRequest);
        return new ResponseEntity<>(updatedBrand, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> getBrandById(@PathVariable("id") Long brandId) {
        BrandResponse brand = brandServiceIMPL.getBrandById(brandId);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable("id") Long brandId) {
        brandServiceIMPL.deleteBrandById(brandId);
        return new ResponseEntity<>("Brand deleted successfully", HttpStatus.OK);
    }


}

