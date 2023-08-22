package com.sample.springapi.domain.repository;

import java.util.List;
import java.util.Optional;

import com.sample.springapi.domain.dto.Purchase;

public interface PurchaseRepository {
    
    List<Purchase> getAll();
    // Optional permite manejar datos, encerrándolos en un opcional, que pueden existir o no.
    Optional<List<Purchase>> getByClient(String cliendId);
    Purchase save(Purchase purchase); 
}
