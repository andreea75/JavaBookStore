package com.example.testtest.service.book;

import com.example.testtest.models.Book;
import com.example.testtest.models.BookCategory;
import com.example.testtest.models.Genre;

import java.util.List;

public interface BookService {
    Book add(Book book);
    List<Book> getAll();
    Book getById(Long id);
    void deleteById(Long id);
    List<Book> getByGenre(Genre genre);
    List<Book> getByLanguage(String language);
    List<Book> getByCategory(BookCategory category);
}
