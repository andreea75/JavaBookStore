package com.example.testtest.service.book;

import com.example.testtest.models.BookDetails;

public interface BookDetailsService {
    BookDetails updateDetails(Long id, BookDetails request);
}
