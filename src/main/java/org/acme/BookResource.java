package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/api/books")
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks(){
        logger.info("Getting all books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/count")
    public int count(){
        logger.info("Getting book count");
        return getAllBooks().size() ;
    }

    @GET
    @Path("/{id}")
    public Book getBookById(@PathParam("id") int id){
        logger.info("Getting book by id: " + id);
        return bookRepository.getBookById(id);
    }
}
