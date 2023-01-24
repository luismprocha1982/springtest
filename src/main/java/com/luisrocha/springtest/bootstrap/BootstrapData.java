package com.luisrocha.springtest.bootstrap;

import com.luisrocha.springtest.model.Author;
import com.luisrocha.springtest.model.Book;
import com.luisrocha.springtest.model.Publisher;
import com.luisrocha.springtest.repository.AuthorRepository;
import com.luisrocha.springtest.repository.BookRepository;
import com.luisrocha.springtest.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootstrapData(final AuthorRepository authorRepository, final BookRepository bookRepository, final PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        final Author bruceEckel = new Author("Bruce", "Eckel");
        final Book thinkingInJava = new Book("Thinking in Java", "ISBN-10.0131872486");
        final Publisher prenticeHall = new Publisher("Prentice Hall", "Room Number, Hall", "Kent", "Ohio", "44243");

        authorRepository.save(bruceEckel);
        bookRepository.save(thinkingInJava);
        publisherRepository.save(prenticeHall);

        final Publisher manning = new Publisher("Manning", "20 Baldwin Road", "Shelter Island", "New York", "11964");

        final Book springInAction = new Book("Spring in Action", "ISBN9781617294945");
        springInAction.setPublisher(manning);

        final Author craigWalls = new Author("Craig", "Walls");
        craigWalls.getBooks().add(springInAction);
        springInAction.getAuthors().add(craigWalls);

        publisherRepository.save(manning);
        authorRepository.save(craigWalls);
        bookRepository.save(springInAction);

        System.out.println("Starting Bootstrap Data: ");
        System.out.println("Loaded " + authorRepository.count() + " authors!");
        System.out.println("Loaded " + bookRepository.count() + " books!");
        System.out.println("Loaded " + publisherRepository.count() + " publishers!");
    }
}
