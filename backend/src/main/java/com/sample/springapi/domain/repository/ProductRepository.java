package com.sample.springapi.domain.repository;

import java.util.List;
import java.util.Optional;

import com.sample.springapi.domain.dto.Product;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProductos(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
