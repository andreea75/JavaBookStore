package com.example.testtest.service.book;

import com.example.testtest.models.Author;
import com.example.testtest.models.BookDetails;

import java.util.List;

public interface BookDetailsService {
    List<BookDetails> getAll();
    BookDetails getById(Long id);
    BookDetails updateDetails(Long id, BookDetails request);
}
