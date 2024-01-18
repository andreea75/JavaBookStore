package com.example.testtest.controller;

import com.example.testtest.models.BookCategory;
import com.example.testtest.service.book.BookCategoryServiceImpl;
import com.example.testtest.shared.Messages;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class BookCategoryController {
    private final BookCategoryServiceImpl bookCategoryService;

    public BookCategoryController(BookCategoryServiceImpl bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }

    @PostMapping("/createCategory")
    public ResponseEntity<?> createCategory(@RequestBody BookCategory bookCategory) {

        bookCategoryService.add(bookCategory);
        return ResponseEntity.ok(Messages.BOOK_CATEGORY_CREATED);
    }

    @GetMapping("/getAll")
    public List<BookCategory> getAll() {
        return bookCategoryService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bookCategoryService.getById(id));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        bookCategoryService.deleteById(id);
        return ResponseEntity.ok(Messages.BOOK_CATEGORY_DELETED);
    }
}
