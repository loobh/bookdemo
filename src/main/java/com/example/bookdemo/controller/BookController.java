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
    @Operation(summary = "Create books record")
    public ResponseEntity<String> addUser(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.ok("Create user information successfully");
    }

    @Tag(name = "Get", description = "Read")
    @GetMapping
    @Operation(summary = "View all books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @Tag(name = "Get")
    @GetMapping("/get")
    @Operation(summary = "View book by id")
    public Book getBook(@RequestParam Long id) {
        return bookService.getBook(id);
    }

    @Tag(name = "Put", description = "Update")
    @PutMapping("/update/{id}")
    @Operation(summary = "Update book information")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        //return ResponseEntity.noContent().build();
        return ResponseEntity.ok("Update book information successfully");

    }

    @Tag(name = "Delete", description = "Delete")
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete books")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Delete book successfully");
    }


}
