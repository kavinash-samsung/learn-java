package com.example.springtransaction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ORDERS")
@Getter
@Setter
public class Order {
    @Id
    private int id;
    private int productId;
    private int quantity;
    private double totalPrice;
}
