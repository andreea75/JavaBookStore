package com.example.testtest.service;

import com.example.testtest.models.BookCategory;
import com.example.testtest.repository.BookCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    private final BookCategoryRepository bookCategoryRepository;

    public BookCategoryServiceImpl(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    @Override
    public BookCategory add(BookCategory bookCategory) {
        return bookCategoryRepository.save(bookCategory);
    }

    @Override
    public List<BookCategory> getAll() {
        return bookCategoryRepository.findAll();
    }

    @Override
    public BookCategory getById(Long id) {
        Optional<BookCategory> bookCategory = bookCategoryRepository.findById(id);
        return bookCategory.orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        bookCategoryRepository.deleteById(id);
    }
}
