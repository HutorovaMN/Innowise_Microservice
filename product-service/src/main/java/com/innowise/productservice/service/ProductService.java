package com.innowise.productservice.service;

import com.innowise.productservice.dto.ProductRequest;
import com.innowise.productservice.dto.ProductResponse;
import com.innowise.productservice.model.Product;
import com.innowise.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private ProductRepository productRepository;

    public void CreateProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public void DeleteProduct(String name) {
        Product product = new Product();
        product.setName(name);
        productRepository.delete(product);
        log.info("Product {} is deleted", product.getName());
    }

}

