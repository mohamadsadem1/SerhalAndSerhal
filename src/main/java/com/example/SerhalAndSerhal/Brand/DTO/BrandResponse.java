package com.example.SerhalAndSerhal.Brand.DTO;

import com.example.SerhalAndSerhal.Product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BrandResponse {
    private Long id;

    private String name;

    private String timeCreated;

    private String timeUpdated;


}
