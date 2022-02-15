package pro.sky.lessons.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pro.sky.lessons.model.Book;

import java.util.Collection;
import java.util.HashMap;

@Service
public class BookService {
    private final HashMap<Integer, Book> books = new HashMap<>();
    private int lastId = 0;

    public Book createBook(Book book) {
        book.setId(++lastId);
        books.put(lastId, book);
        return book;
    }

    public Book findBook(int id) {
        return books.get(id);
    }

    public Book editBook(Book book) {
        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
            return book;
        }
        return null;
    }

    public Book deleteBook(int id) {
        return books.remove(id);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }
}
