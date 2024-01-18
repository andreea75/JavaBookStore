package com.example.testtest.service;

import com.example.testtest.models.BookCategory;

import java.util.List;

public interface BookCategoryService {
    BookCategory add(BookCategory bookCategory);
    List<BookCategory> getAll();
    BookCategory getById(Long id);
    void deleteById(Long id);
}
