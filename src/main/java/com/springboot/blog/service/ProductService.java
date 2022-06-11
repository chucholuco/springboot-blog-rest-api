package com.springboot.blog.service;

import com.springboot.blog.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> searchProducts(String query);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);
}
