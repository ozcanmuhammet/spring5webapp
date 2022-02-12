package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author tolkien = new Author("J.R.R", "Tolkien");
        Book lotr = new Book("Lord of the Rings", "123123");
        tolkien.getBooks().add(lotr);
        lotr.getAuthors().add(tolkien);

        Publisher metis = new Publisher("Metis", "Beyoglu", "Istanbul", "Turkey", "34");

        lotr.setPublisher(metis);
        metis.getBooks().add(lotr);

        authorRepository.save(tolkien);
        bookRepository.save(lotr);
        publisherRepository.save(metis);

        System.out.println("Started in BootStrap...");
        System.out.println("Count of books: " + bookRepository.count());
        System.out.println("Publisher: " + publisherRepository.count());



    }
}
