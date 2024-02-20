package com.example.testtest.controller;

import com.example.testtest.models.Author;
import com.example.testtest.models.BookDetails;
import com.example.testtest.service.book.BookDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book/details")
public class BookDetailsController {
    private final BookDetailsServiceImpl bookDetailsService;

    public BookDetailsController(BookDetailsServiceImpl bookDetailsService) {
        this.bookDetailsService = bookDetailsService;
    }
    @GetMapping("getAll")
    public List<BookDetails> getAll() {
        return bookDetailsService.getAll();
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bookDetailsService.getById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateDetails(@PathVariable Long id,
                                           @Validated
                                           @RequestBody BookDetails bookDetails) {
        return ResponseEntity.ok().body(bookDetailsService.updateDetails(id, bookDetails));
    }
}
