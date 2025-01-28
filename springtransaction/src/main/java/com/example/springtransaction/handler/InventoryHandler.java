package com.example.springtransaction.handler;

import com.example.springtransaction.entity.Product;
import com.example.springtransaction.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryHandler {


    private final InventoryRepository inventoryRepository;

    public InventoryHandler(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }


    public Product updateProductDetails(Product product) {
        return inventoryRepository.save(product);
    }


    public Product getProduct(int id) {
        return inventoryRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Product not available with id : " + id)
                );
    }
}