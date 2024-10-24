package com.example.bookdemo.dao;

import com.example.bookdemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book getBookById(Long id);
}
