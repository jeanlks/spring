package com.spring.web.spring5webapp.repository;

import com.spring.web.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
