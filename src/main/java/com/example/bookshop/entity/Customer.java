package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customerName;
    private String email;
    private String address;
    private String phoneNumber;
    @OneToMany(mappedBy = "customer")
    private List<Order>orders=new ArrayList<>();
    public void addOrder(Order order){
        order.setCustomer(this);
        orders.add(order);
    }
    public Customer(String customerName, String email, String address, String phoneNumber) {
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
