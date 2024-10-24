package com.example.bookdemo.controller;

import com.example.bookdemo.entity.Store;
import com.example.bookdemo.vo.BookStoreReq;
import com.example.bookdemo.service.BookStoreService;
import com.example.bookdemo.vo.BookStoreVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookStoreController {
    @Autowired
    private BookStoreService bookStoreService;

    @Tag(name = "Add", description = "Write")
    @PostMapping("/add")
    @Operation(summary = "Create store and books record")
    public ResponseEntity<String> addBookStore(@RequestBody BookStoreReq req){
        bookStoreService.addBookStore(req);
        return ResponseEntity.ok("Create bookstore information successfully");
    }

//    @Tag(name = "get", description = "Read")
//    @GetMapping
//    @Operation(summary = "View all bookstore")
//    public List<Store> getBookStores() {
//        return bookStoreService.getBookStore();
//    }

    @Tag(name = "Get")
    @GetMapping("/store/{storeId}")
    @Operation(summary = "View bookstore address by id")
    public ResponseEntity <List<String>> getBookStoresByStoreId(@PathVariable Long storeId) {
        List<String> addresses = bookStoreService.getBookStore(storeId);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @Tag(name = "Get")
    @GetMapping("/store/{storeId}/books")
    @Operation(summary = "View book list in a store by store id")
    public ResponseEntity<BookStoreVO> getBookStoreList(@PathVariable Long storeId) {
        BookStoreVO bookStoreVO = bookStoreService.getBookStoreList(storeId);
        return new ResponseEntity<>(bookStoreVO, HttpStatus.OK);
    }

    @Tag(name = "Update", description = "Update existing store and books record")
    @PutMapping("/update/{bookStoreId}")
    @Operation(summary = "Update store and books record by BookStore ID")
    public ResponseEntity<String> updateBookStore(@PathVariable Long bookStoreId, @RequestBody BookStoreReq req) {
        bookStoreService.updateBookStore(bookStoreId, req);
        return ResponseEntity.ok("Updated bookstore information successfully");
    }

    @Tag(name = "Delete", description = "Delete store and books record")
    @DeleteMapping("/delete/{bookStoreId}")
    @Operation(summary = "Delete store and books record by BookStore ID")
    public ResponseEntity<String> deleteBookStore(@PathVariable Long bookStoreId) {
        bookStoreService.deleteBookStore(bookStoreId);
        return ResponseEntity.ok("Deleted bookstore information successfully");
    }



}
