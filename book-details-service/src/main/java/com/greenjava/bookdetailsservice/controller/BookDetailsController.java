package com.greenjava.bookdetailsservice.controller;

import com.greenjava.bookdetailsservice.client.BookPriceProxy;
import com.greenjava.bookdetailsservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookDetailsController {

    @Autowired
    private BookPriceProxy bookPriceProxy;

    @GetMapping("book-details/{name}/{quantity}")
    public Book getBookDetails(@PathVariable("name") String name,
                               @PathVariable("quantity")
            int quantity) {

        System.out.println(name+ " "+quantity);
        Book bookPrice = bookPriceProxy.book(name);

//        Book bookPrice=new Book();
//        bookPrice.setPrice(1200);
//        bookPrice.setName("Java");
//        System.out.println(bookPrice);
//
        bookPrice.setPrice(bookPrice.getPrice()*quantity);

        return bookPrice;
    }

}
