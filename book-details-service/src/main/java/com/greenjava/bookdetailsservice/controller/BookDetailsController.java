package com.greenjava.bookdetailsservice.controller;

import com.greenjava.bookdetailsservice.client.BookPriceProxy;
import com.greenjava.bookdetailsservice.model.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookDetailsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookPriceProxy bookPriceProxy;

    @GetMapping("book-details/{name}/{quantity}")
    @HystrixCommand(fallbackMethod = "faultTolerance")
    public Book getBookDetails(@PathVariable("name") String name,
                               @PathVariable("quantity")
                                       int quantity) {

        System.out.println(name + " " + quantity);
        Book bookPrice = bookPriceProxy.book(name);


        bookPrice.setPrice(bookPrice.getPrice() * quantity);

        logger.info("{}", bookPrice);
        return bookPrice;
    }


    public Book faultTolerance(String s,int i){
        Book book=new Book();
        book.setName("dummy");
        book.setPrice(1);
        book.setId(0);
        return book;
    }

}
