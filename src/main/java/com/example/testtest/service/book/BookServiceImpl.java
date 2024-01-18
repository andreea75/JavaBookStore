package com.example.testtest.service.book;

import com.example.testtest.models.Book;
import com.example.testtest.models.BookCategory;
import com.example.testtest.models.Genre;
import com.example.testtest.repository.BookRepository;
import com.example.testtest.service.book.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book add(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getByGenre(Genre genre) {
        return bookRepository.getByGenre(genre);
    }

    @Override
    public List<Book> getByLanguage(String language) {
        return bookRepository.getByLanguage(language);
    }

    @Override
    public List<Book> getByCategory(BookCategory category) {
        return bookRepository.getByCategory(category);
    }
}
