package com.greenjava.bookpriceservice.repo;

import com.greenjava.bookpriceservice.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepo extends CrudRepository<Book,Integer> {

    Optional<Book> findByName(String name);
}
