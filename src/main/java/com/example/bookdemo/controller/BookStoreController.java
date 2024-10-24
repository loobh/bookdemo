package com.example.bookdemo.controller;

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

    @GetMapping("/store/{storeId}")
    @Operation(summary = "View bookstore by id")
    public ResponseEntity <List<String>> getBookStoresByStoreId(@PathVariable int storeId) {
        List<String> addresses = bookStoreService.getBookStore(storeId);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/store/{storeId}/books")
    public ResponseEntity<BookStoreVO> getBookStoreList(@PathVariable int storeId) {
        BookStoreVO bookStoreVO = bookStoreService.getBookStoreList(storeId);
        return new ResponseEntity<>(bookStoreVO, HttpStatus.OK);
    }

}
