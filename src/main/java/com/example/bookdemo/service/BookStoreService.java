package com.example.bookdemo.service;

import com.example.bookdemo.dao.BookRepository;
import com.example.bookdemo.dao.BookStoreRepository;
import com.example.bookdemo.dao.StoreRepository;
import com.example.bookdemo.vo.BookStoreReq;
import com.example.bookdemo.entity.Book;
import com.example.bookdemo.entity.BookStore;
import com.example.bookdemo.entity.Store;
import com.example.bookdemo.vo.BookStoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookStoreService {
    @Autowired
    private BookStoreRepository bookStoreRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StoreRepository storeRepository;

    public void addBookStore(BookStoreReq req) {
        int storeId = req.getStoreId();
        int bookId = req.getBookId();

        BookStore newBookStore = new BookStore();

        Book book = bookRepository.getBookById(bookId);
        newBookStore.setBook(book);

        Store store = storeRepository.getStoreById(storeId);
        newBookStore.setStore(store);

        bookStoreRepository.save(newBookStore);
    }

//    public List<Store> getBookStore() {
//        List<BookStore> bookStore = bookStoreRepository.findByStoreId(1);
//        bookStore.forEach(store -> System.out.println(store.getStore().getAddress()));
//        return null;
//    }

//    public List<String> getBookStore(int storeId) {
//        List<BookStore> bookStores = bookStoreRepository.findByStoreId(storeId);
//
//        List<String> addresses = new ArrayList<>();
//
//        bookStores.forEach(store -> addresses.add(store.getStore().getAddress()));
//
//    return addresses;
//}

    public List<String> getBookStore(int storeId) {
        List<BookStore> bookStores = bookStoreRepository.findByStoreId(storeId);
        ///This will only look at the first saved data.
        //bookStores.get(0).getStore().getAddress();
        ///This will loop all the data only show one if all different
        return bookStores.stream()
                .map(store -> store.getStore().getAddress())
                .distinct()
                .collect(Collectors.toList());
    }

    public BookStoreVO getBookStoreList(int storeId) {
        List<BookStore> bookStoreList = bookStoreRepository.findByStoreId(storeId);
        if (bookStoreList.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No books found for store with id: " + storeId);
        }
        Store store = bookStoreList.get(0).getStore();

        List<String> bookTitles = bookStoreList.stream()
                .map(bookStore -> bookStore.getBook().getTitle())
                .collect(Collectors.toList());

        return new BookStoreVO(store.getShopName(), store.getAddress(), bookTitles);
    }
}





