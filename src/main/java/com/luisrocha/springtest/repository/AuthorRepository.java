package com.luisrocha.springtest.repository;

import com.luisrocha.springtest.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
