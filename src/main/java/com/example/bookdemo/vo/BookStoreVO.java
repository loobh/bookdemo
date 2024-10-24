package com.example.bookdemo.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookStoreVO {
    private String shopName;
    private String address;
    private List<String> titles;

    public BookStoreVO(String shopName, String address, List<String> titles) {
        this.shopName = shopName;
        this.address = address;
        this.titles = titles;
    }
}

