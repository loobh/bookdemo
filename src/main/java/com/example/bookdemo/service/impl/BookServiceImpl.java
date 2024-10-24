package com.example.bookdemo.service.impl;

import com.example.bookdemo.dao.BookRepository;
import com.example.bookdemo.entity.Book;
import com.example.bookdemo.service.BookService;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }


    @Override
    public Book updateBook(int id, Book book) {
        bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid book id "+ id));

        book.setId(id);
        bookRepository.save(book);
        return book;

    }

    @Override
    public Book getBook(int id) {
        return bookRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid book id "+ id));
    }

    @Override
    public void deleteBook(int id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid book id "+ id));

        bookRepository.delete(book);

    }

//    public static Object testHttp(){
//        int response = HttpRequest.get("https://api.github.com/users/octocat/repos").code();
//       System.out.println(response);
//
//        String response = HttpRequest.get("https://api.github.com/users/octocat/repos").body();
//        System.out.println("Response was: " + response);
//        return null;
///This is Draft
//    public static String testHttp() {
//    // Fetch data from the API
//    String response = HttpRequest.get("https://api.github.com/users/octocat/repos").body();
//    System.out.println("Response was: " + response);
//    return response;
//    }
//
//    public static void main(String[] args) {
//        testHttp();
//
//        Gson gson = new Gson();
//
//        try (Reader reader = new FileReader("staff.json")) {
//
//            // Convert JSON File to Java Object
//            JsonObject jsonobject = gson.fromJson(reader, JsonObject.class);
//
//            // print staff object
//            System.out.println(jsonobject);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

public static String testHttp() {
    // Fetch data from the API using Unirest
    HttpResponse<String> response = Unirest.get("https://api.github.com/users/octocat/repos")
            .asString();
    System.out.println("Response was: " + response.getBody());
    return response.getBody();
}

    public static void main(String[] args) {
        // Fetch the JSON response
        String jsonResponse = testHttp();

        // Initialize Gson
        Gson gson = new Gson();

        // Convert the JSON string to a JsonArray
        JsonArray jsonArray = gson.fromJson(jsonResponse, JsonArray.class);

        // Loop through the JSON array and map the required attributes to the JsonObject class
        for (int i = 0; i < jsonArray.size(); i++) {
            com.google.gson.JsonObject jsonElement = jsonArray.get(i).getAsJsonObject();

            // Extracting attributes
            Long id = jsonElement.get("id").getAsLong();
            String node_id = jsonElement.get("node_id").getAsString();
            String name = jsonElement.get("name").getAsString();
            String full_name = jsonElement.get("full_name").getAsString();
            Boolean is_private = jsonElement.get("private").getAsBoolean();

            // Print out the values
            System.out.println("ID: " + id);
            System.out.println("Node ID: " + node_id);
            System.out.println("Name: " + name);
            System.out.println("Full Name: " + full_name);
            System.out.println("Is Private: " + is_private);
            System.out.println("--------------------------------");
        }


    }



}
