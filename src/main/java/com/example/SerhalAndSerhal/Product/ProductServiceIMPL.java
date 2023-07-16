package com.example.SerhalAndSerhal.Product;

import com.example.SerhalAndSerhal.Product.dto.ProductRequest;
import com.example.SerhalAndSerhal.Product.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceIMPL implements ProductService{

    private final ProductRepository productRepository;

    private ProductMapper productMapper;

    private ModelMapper modelMapper;

    public void createProduct(ProductRequest productRequest) {

        Product product= modelMapper.map(productRequest, Product.class);
        Product savedproduct= productRepository.save(product);
        log.info("Product saved",product.getId());
    }

    @Override
    public void updateProduct(ProductRequest productRequest) {

    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public ProductResponse getProductById(Long id) {
        return null;
    }

    @Override
    public ProductRequest getProductByName(String name) {
        return null;
    }

    @Override
    public ProductRequest getProductByBrand(String brand) {
        return null;
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products= productRepository.findAll();
       return products.stream().map(this :: mapToProductResponse).toList();

    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
              .id(product.getId())
              .name(product.getName())
              .description(product.getDescription())
              .price(product.getPrice())
              .build();
    }
}
