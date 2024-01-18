package com.example.testtest.service;

import com.example.testtest.models.BookDetails;

public interface BookDetailsService {
    BookDetails updateDetails(Long id, BookDetails request);
}
