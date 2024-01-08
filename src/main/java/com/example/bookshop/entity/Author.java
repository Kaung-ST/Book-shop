package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String authorName;
    private String email;
    @OneToMany(mappedBy = "author",
    cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Book>books=new ArrayList<>();

    public Author(String authorName, String email) {
        this.authorName = authorName;
        this.email = email;
    }

    public void addBook(Book book){
        book.setAuthor(this);
        books.add(book);
    }
}
