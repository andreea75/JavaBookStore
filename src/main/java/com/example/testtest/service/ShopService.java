package com.example.testtest.service;

import com.example.testtest.models.Book;
import jakarta.transaction.Transactional;

public interface ShopService {
    @Transactional
    Book buyBook(Long id, int no);
}
