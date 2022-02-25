package pro.sky.lessons.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.lessons.model.Book;
import pro.sky.lessons.services.BookService;


@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"/{id}"}) // GET https://localhost:8080/books/23
    public ResponseEntity<Book> getBookInfo(@PathVariable long id) {
        Book book = bookService.findBook(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping // POST https://localhost:8080/books
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping // PUT https://localhost:8080/books
    public ResponseEntity<Book> editBook(@RequestBody Book book) {
        Book foundBook = bookService.editBook(book);
        if (foundBook == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundBook);
    }

    @DeleteMapping("/{id}")  // DELETE https://localhost:8080/books/23
    public ResponseEntity<Book> deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping // GET https://localhost:8080/books
    public ResponseEntity findBooks(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String namePart) {
        if (name != null && !name.isBlank()) {
            return ResponseEntity.ok(bookService.findBookByName(name));
        }
        if (author != null && !author.isBlank()) {
            return ResponseEntity.ok(bookService.findByAuthor(author));
        }
        if (namePart != null && !namePart.isBlank()) {
            return ResponseEntity.ok(bookService.findByNamePart(namePart));
        }
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}