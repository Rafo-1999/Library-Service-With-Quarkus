package org.library;

import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks() {
        return List.of(new Book(1, "Title1", "Author1", 2025, "genre1"),
                       new Book(2, "Title2", "Author2", 2025, "genre2"),
                       new Book(3, "Title3", "Author3", 2025, "genre3"),
                       new Book(4, "Title4", "Author4", 2025, "genre4"),
                       new Book(5, "Title5", "Author5", 2025, "genre5"));
    }

    public Optional<Book> getBookById(@PathParam("id") int id) {
        return getAllBooks().stream().filter(book-> book.getId() == id).findFirst();
    }
}
