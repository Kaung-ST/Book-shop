package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "publisher" , cascade =  CascadeType.ALL ,orphanRemoval = true)
    private List<Book> books=new ArrayList<>();
    public Publisher(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public void addBook(Book book){
        book.setPublisher(this);
        books.add(book);
    }
}
