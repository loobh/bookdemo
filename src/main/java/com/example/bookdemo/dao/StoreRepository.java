package com.example.bookdemo.dao;

import com.example.bookdemo.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Store getStoreById(Long storeId);
}




