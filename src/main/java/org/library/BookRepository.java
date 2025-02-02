package org.library;

import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(new Book(1, "Effective Java", "Joshua Bloch", 2018, genre),
            new Book(2, "Java Concurrency in Practice", "Brian Goetz", 2006, genre),
            new Book(3, "Clean Code", "Robert C. Martin", 2008, genre),
            new Book(4, "Spring in Action", "Craig Walls", 2018, genre),
            new Book(5, "Java Performance: The Definitive Guide", "Scott Oaks", 2014, genre));
    }


    public Optional<Book> getBookById(@PathParam("id") int id) {
        return getAllBooks().stream().filter(book-> book.getId() == id).findFirst();
    }
}
