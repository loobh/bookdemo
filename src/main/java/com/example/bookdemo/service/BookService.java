package com.example.bookdemo.service;

import com.example.bookdemo.entity.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    List<Book> getBooks();

    Book updateBook(Long id, Book book);

    Book getBook(Long id);

    void deleteBook(Long id);
}


