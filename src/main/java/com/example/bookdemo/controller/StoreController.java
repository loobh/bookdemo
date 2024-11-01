package com.example.bookdemo.controller;

import com.example.bookdemo.entity.Book;
import com.example.bookdemo.entity.Store;
import com.example.bookdemo.service.StoreServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    public StoreServiceImpl storeService;

    @Tag(name = "Add", description = "Write")
    @PostMapping("/add")
    @Operation(summary = "Create store record")
    public ResponseEntity<String> addStore(@RequestBody Store store) {
        storeService.addStore(store);
        return ResponseEntity.ok("Create store information successfully");
    }

    @Tag(name = "Get")
    @GetMapping
    @Operation(summary = "View all stores")
    public List<Store> getStores() {
        return storeService.getStores();
    }

    @Tag(name = "Get")
    @GetMapping("/get")
    @Operation(summary = "View store by id")
    public Store getStore(@RequestParam Long id) {
        return storeService.getStore(id);
    }

    @Tag(name = "Put")
    @PutMapping("/update/{id}")
    @Operation(summary = "Update store information")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Store store) {
        storeService.updateStore(id, store);
        return ResponseEntity.ok("Update store information successfully");

    }


    @Tag(name = "Delete")
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete stores")
    public ResponseEntity<String> deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
        return ResponseEntity.ok("Delete store successfully");
    }

//    @GetMapping("/store/{id}/books")
//    @Operation(summary = "View all books sold by the store")
//    public List<Book> getBooksByStoreId(@PathVariable int id) {
//        return storeService.getBooksByStoreId(id);
//    }

}
