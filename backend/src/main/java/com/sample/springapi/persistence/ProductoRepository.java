package com.sample.springapi.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.springapi.domain.dto.Product;
import com.sample.springapi.domain.repository.ProductRepository;
import com.sample.springapi.persistence.crud.ProductoCrudRepository;
import com.sample.springapi.persistence.entity.Producto;
import com.sample.springapi.persistence.mapper.ProductMapper;

// Repository. Esta clase se encarga de interactuar con la BD
// Component. Es una clase general de Spring
@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired // Para no crear objetos manualmente (spring se encarga, siempre y cuando sea un componente de Spring)
    private ProductMapper mapper;
    
    @Override
    public List<Product> getAll() {
        
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProductos(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }
    
    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }

}
