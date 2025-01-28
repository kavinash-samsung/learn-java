package com.example.springtransaction.service;

import com.example.springtransaction.entity.Order;
import com.example.springtransaction.entity.Product;
import com.example.springtransaction.error.DatabaseCrashException;
import com.example.springtransaction.handler.InventoryHandler;
import com.example.springtransaction.handler.OrderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderProcessingService {
    @Autowired
    private OrderHandler orderHandler;
    @Autowired
    private InventoryHandler inventoryHandler;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Order placeAnOrder(Order order) throws DatabaseCrashException {
        // get product from inventory
        Product product = inventoryHandler.getProduct(order.getProductId());
        // validate stock availability
        validateStockAvailibility(order, product);
        // update total price in order entity
        order.setTotalPrice(order.getQuantity()*product.getPrice());
        updateInventoryStock(order, product);
        return orderHandler.saveOrder(order);

        //
    }

    private static void validateStockAvailibility(Order order, Product product) throws DatabaseCrashException {
        if(order.getQuantity() > product.getStockQuantity()){
            throw new DatabaseCrashException("Insufficient Stock !");
        }
    }

    private void updateInventoryStock(Order order, Product product){
        int availableStock = product.getStockQuantity() - order.getQuantity();
        product.setStockQuantity(availableStock);
        inventoryHandler.updateProductDetails(product);
    }

}
