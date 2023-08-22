package com.sample.springapi.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.springapi.domain.dto.Purchase;
import com.sample.springapi.domain.repository.PurchaseRepository;
import com.sample.springapi.persistence.crud.CompraCrudRepository;
import com.sample.springapi.persistence.entity.Compra;
import com.sample.springapi.persistence.mapper.PurchaseMapper;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        // 1. Llamar del CrudRepository, findAll
        // 2. Castear resultado
        // 3. Convertir resultado con el mapper
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String cliendId) {
        return compraCrudRepository.findByIdCliente(cliendId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);

        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
    
}
