package com.example.testtest.service;

import com.example.testtest.exceptions.BookDetailsNotFoundException;
import com.example.testtest.models.BookDetails;
import com.example.testtest.repository.BookDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class BookDetailsServiceImpl implements BookDetailsService{
    private final BookDetailsRepository bookDetailsRepository;

    public BookDetailsServiceImpl(BookDetailsRepository bookDetailsRepository) {
        this.bookDetailsRepository = bookDetailsRepository;
    }

    @Override
    public BookDetails updateDetails(Long id, BookDetails request) {
        bookDetailsRepository.findById(id).orElseThrow(BookDetailsNotFoundException::new);

        return bookDetailsRepository.save(request);
    }
}
