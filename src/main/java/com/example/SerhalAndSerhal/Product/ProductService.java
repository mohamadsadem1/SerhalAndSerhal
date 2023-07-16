package com.example.SerhalAndSerhal.Product;

import com.example.SerhalAndSerhal.Product.dto.ProductRequest;
import com.example.SerhalAndSerhal.Product.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    public void createProduct(ProductRequest productRequest);
    public void updateProduct(ProductRequest productRequest);
    public void deleteProduct(Long id);

    public ProductResponse getProductById(Long id);
    public ProductRequest getProductByName(String name);
    public ProductRequest getProductByBrand(String brand);
    public List<ProductResponse> getAllProducts();

}
