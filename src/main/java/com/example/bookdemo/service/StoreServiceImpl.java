package com.example.bookdemo.service;

import com.example.bookdemo.dao.StoreRepository;
import com.example.bookdemo.entity.Book;
import com.example.bookdemo.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StoreServiceImpl {

    @Autowired
    private StoreRepository storeRepository;

    public void addStore(Store store) {
        storeRepository.save(store);
    }

    public List <Store> getStores() {
        return storeRepository.findAll();
    }

    public Store getStore(int id) {
        return storeRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid store id "+ id));
    }

    public Store updateStore(int id, Store store) {
        storeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid store id "+ id));

        store.setId(id);
        storeRepository.save(store);

        return store;
    }

    public void deleteStore(int id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid store id "+ id));

        storeRepository.delete(store);
    }

}

