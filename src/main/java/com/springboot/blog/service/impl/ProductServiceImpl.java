package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Product;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.repository.ProductRepository;
import com.springboot.blog.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> searchProducts(String query) {
        return productRepository.searchProducts(query);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product dbProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product", "id", id));

        dbProduct.setSku(product.getSku());
        dbProduct.setName(product.getName());
        dbProduct.setDescription(product.getDescription());
        dbProduct.setPrice(product.getPrice());
        dbProduct.setImageUrl(product.getImageUrl());
        dbProduct.setActive(product.isActive());

        return productRepository.save(dbProduct);

    }
}
