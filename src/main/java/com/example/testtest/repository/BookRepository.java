package com.example.testtest.repository;

import com.example.testtest.models.Book;
import com.example.testtest.models.BookCategory;
import com.example.testtest.models.Genre;
import com.example.testtest.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getByGenre(Genre genre);
    List<Book> getByLanguage(String language);
    List<Book> getByCategory(BookCategory category);
}
