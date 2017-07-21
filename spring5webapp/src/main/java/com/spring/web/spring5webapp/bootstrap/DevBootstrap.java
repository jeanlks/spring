package com.spring.web.spring5webapp.bootstrap;

import com.spring.web.spring5webapp.model.Author;
import com.spring.web.spring5webapp.model.Book;
import com.spring.web.spring5webapp.model.Publisher;
import com.spring.web.spring5webapp.repository.AuthorRepository;
import com.spring.web.spring5webapp.repository.BookRepository;
import com.spring.web.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author author = new Author("teste","teste");
        Publisher publisher = new Publisher("Folha","SP");
        publisherRepository.save(publisher);

        Book book = new Book("teste","teste",publisher);
        author.getBooks().add(book);
        book.getAuthors().add(author);
        authorRepository.save(author);
        bookRepository.save(book);
    }
}
