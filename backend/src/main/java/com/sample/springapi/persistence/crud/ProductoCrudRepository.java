package com.sample.springapi.persistence.crud;

import java.util.List;
import java.util.Optional;

// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sample.springapi.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    // Method Query usando jpa.query-methods
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
    
    // Method Query puro SQL
    // @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
}
