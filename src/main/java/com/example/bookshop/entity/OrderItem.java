package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private int quantity;
    @ManyToOne
    private Book book;
    @JoinColumn(name = "order_id_fk")
    @ManyToOne
    private Order order;
}
