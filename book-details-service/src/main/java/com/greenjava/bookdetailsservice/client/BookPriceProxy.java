package com.greenjava.bookdetailsservice.client;

import com.greenjava.bookdetailsservice.model.Book;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="book-price-service")
@RibbonClient(name="book-price-service")
public interface BookPriceProxy {

    @GetMapping("/book/{name}")
    Book book(@PathVariable("name") String name);

}
