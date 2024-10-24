package com.example.bookdemo.controller;

import com.example.bookdemo.entity.Book;
import com.example.bookdemo.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Tag(name = "Add", description = "Write")
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.ok("Create user information successfully");
    }

    @Tag(name = "get", description = "Read")
    @GetMapping
    @Operation(summary = "View all books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @Tag(name = "get", description = "View selected book by id")
    @GetMapping("/get")
    @Operation(summary = "View book by id")
    public Book getBook(@RequestParam int id) {
        return bookService.getBook(id);
    }

    @Tag(name = "put", description = "Update")
    @PutMapping("/update/{id}")
    @Operation(summary = "Update book information")
    public ResponseEntity<String> updateBook(@PathVariable int id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        //return ResponseEntity.noContent().build();
        return ResponseEntity.ok("Update book information successfully");

    }


    @Tag(name = "delete", description = "Delete")
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete books")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Delete book successfully");
    }


}
