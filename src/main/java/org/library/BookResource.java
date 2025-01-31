package org.library;

import java.util.List;
import java.util.Optional;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {


    @Inject
    BookRepository bookRepository;
    @Inject
    Logger log;

    @GET
    public List<Book> getAllBooks() {
        log.info("All books info found");
        return bookRepository.getAllBooks();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/count")
    public int countAllBooks() {
        log.info("Count all books info found");
        return bookRepository.getAllBooks().size();
    }

    @GET
    @Path("/{id}")
    public Optional<Book> getBookById(@PathParam("id") int id) {
        log.info("Get book by id info found{}");
        return bookRepository.getBookById(id);
    }
}
