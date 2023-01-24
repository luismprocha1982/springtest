package com.luisrocha.springtest.repository;

import com.luisrocha.springtest.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
