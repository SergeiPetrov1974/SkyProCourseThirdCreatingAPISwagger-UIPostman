package pro.sky.lessons.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.lessons.model.Book;
import pro.sky.lessons.services.BookService;

@RestController
@RequestMapping("books")
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("id") //GET http://localhost:8080/books/23
    public Book getBookInfo(@PathVariable Integer id) {
        return bookService.findBook(id);
    }

    @PostMapping//POST http://localhost:8080/books/23
    public Book createBook(Book book) {
        return bookService.createBook(book);
    }
}
