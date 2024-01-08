package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String genreName;
    @ManyToMany(mappedBy = "genres")
    private List<Book> books=new ArrayList<>();
}
