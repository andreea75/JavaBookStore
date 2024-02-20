package com.example.testtest.service.shop;

import com.example.testtest.models.Author;
import com.example.testtest.models.Book;
import javax.transaction.Transactional;
import java.util.List;


public interface ShopService {
    @Transactional
    Book buyBook(Long id, int no);
}
