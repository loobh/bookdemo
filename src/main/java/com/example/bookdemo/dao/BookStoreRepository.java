package com.example.bookdemo.dao;

import com.example.bookdemo.entity.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookStoreRepository extends JpaRepository <BookStore, Long>{


    List<BookStore> findByStoreId(int storeId);

}


