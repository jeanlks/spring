package com.spring.web.spring5webapp.repository;

import com.spring.web.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
