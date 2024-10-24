package com.example.bookdemo.service;

import com.example.bookdemo.entity.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    List<Book> getBooks();


    Book updateBook(int id, Book book);

    Book getBook(int id);

    void deleteBook(int id);
}


