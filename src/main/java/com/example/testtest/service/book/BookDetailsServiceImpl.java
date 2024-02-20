package com.example.testtest.service.book;

import com.example.testtest.exceptions.BookDetailsNotFoundException;
import com.example.testtest.models.BookCategory;
import com.example.testtest.models.BookDetails;
import com.example.testtest.repository.BookDetailsRepository;
import com.example.testtest.service.book.BookDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookDetailsServiceImpl implements BookDetailsService {
    private final BookDetailsRepository bookDetailsRepository;

    public BookDetailsServiceImpl(BookDetailsRepository bookDetailsRepository) {
        this.bookDetailsRepository = bookDetailsRepository;
    }

    @Override
    public List<BookDetails> getAll() {
        return bookDetailsRepository.findAll();
    }

    @Override
    public BookDetails getById(Long id) {
        Optional<BookDetails> bookDetails = bookDetailsRepository.findById(id);
        return bookDetails.orElse(null);
    }

    @Override
    public BookDetails updateDetails(Long id, BookDetails request) {
        bookDetailsRepository.findById(id).orElseThrow(BookDetailsNotFoundException::new);

        return bookDetailsRepository.save(request);
    }
}
