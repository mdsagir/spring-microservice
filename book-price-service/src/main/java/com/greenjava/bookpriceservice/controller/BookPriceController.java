package com.greenjava.bookpriceservice.controller;

import com.greenjava.bookpriceservice.exception.BookNotFound;
import com.greenjava.bookpriceservice.model.Book;
import com.greenjava.bookpriceservice.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookPriceController {

    @Autowired
    private BookRepo bookRepo;

    @GetMapping("book/{name}")
    public Book book(@PathVariable("name") String name) {

        System.out.println("Name "+name);

        Book book = bookRepo.findByName(name).map(Book::new)
                .orElseThrow(() -> new BookNotFound(name + " Not Found!"));

        System.out.println("BOOK  "+book);
        return book;
    }
}
