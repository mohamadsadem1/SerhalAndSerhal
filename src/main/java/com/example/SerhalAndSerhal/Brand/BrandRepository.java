package com.example.SerhalAndSerhal.Brand;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand,Long> {

    public Optional<Brand> findBrandByName(String name);
}
