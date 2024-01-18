package com.example.testtest.controller;

import com.example.testtest.models.Book;
import com.example.testtest.models.BookCategory;
import com.example.testtest.models.Genre;
import com.example.testtest.service.book.BookServiceImpl;
import com.example.testtest.shared.Messages;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book/")
public class BookController {
    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody Book book) {
        bookService.add(book);
        return ResponseEntity.ok(Messages.BOOK_CREATED);
    }

    @GetMapping("getAll")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok(Messages.BOOK_DELETED);
    }

    @GetMapping("getByGenre/{genre}")
    public List<Book> getByGenre(@PathVariable Genre genre) {
        return bookService.getByGenre(genre);
    }

    @GetMapping("getByLanguage/{language}")
    public List<Book> getByLanguage(@PathVariable String language) {
        return bookService.getByLanguage(language);
    }

    @GetMapping("getByCategory/{category}")
    public List<Book> getByCategory(@PathVariable BookCategory category) {
        return bookService.getByCategory(category);
    }
}
