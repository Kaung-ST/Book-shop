package com.example.bookshop.dao;

import com.example.bookshop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BokDao extends JpaRepository<Book,Integer> {
}
