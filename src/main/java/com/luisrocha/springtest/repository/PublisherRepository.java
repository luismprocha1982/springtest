package com.luisrocha.springtest.repository;

import com.luisrocha.springtest.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
