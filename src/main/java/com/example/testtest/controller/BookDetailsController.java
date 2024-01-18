package com.example.testtest.controller;

import com.example.testtest.models.BookDetails;
import com.example.testtest.service.BookDetailsService;
import com.example.testtest.service.BookDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/book/details")
public class BookDetailsController {
    private final BookDetailsServiceImpl bookDetailsService;

    public BookDetailsController(BookDetailsServiceImpl bookDetailsService) {
        this.bookDetailsService = bookDetailsService;
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateDetails(@PathVariable Long id,
                                           @Validated
                                           @RequestBody BookDetails bookDetails) {
        return ResponseEntity.ok().body(bookDetailsService.updateDetails(id, bookDetails));
    }
}
