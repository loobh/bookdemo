package com.example.bookdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BookStore {

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

}
