package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;

import java.util.List;

@ApplicationScoped
public class BookRepository {
    public List<Book> getAllBooks(){
        return List.of(
                Book.builder().id(1).title("The Catcher in the Rye").author("J.D. Salinger").yearOfPublication(1951).build(),
                Book.builder().id(2).title("1984").author("George Orwell").yearOfPublication(1949).build(),
                Book.builder().id(3).title("To Kill a Mockingbird").author("Harper Lee").yearOfPublication(1960).build(),
                Book.builder().id(4).title("The Great Gatsby").author("F. Scott Fitzgerald").yearOfPublication(1925).build()
        );
    }

    public Book getBookById(@PathParam("id") int id){
        return getAllBooks().stream().filter(book -> book.id == id).findFirst().orElse(null);
    }
}
