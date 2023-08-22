package com.sample.springapi.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.springapi.domain.dto.Product;
import com.sample.springapi.domain.repository.ProductRepository;

@Service // Service. Intemerdiario entre controlador y repositorio
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        // El intermediario (service), puede regresar una respuesta en este caso booleana 
        // para saber si logró eliminar el item

        // Consulta si existe el producto para saber si es posible eliminar y por medio de map logra el condicional
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
