package com.example.bookdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private String publisher;
    private double price;
    private Date publishedDate;

    @OneToMany(mappedBy = "book")
    private List<BookStore> bookStores;
}
