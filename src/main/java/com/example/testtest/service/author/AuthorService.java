package com.example.testtest.service.author;

import com.example.testtest.models.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    Author add(Author author);
    List<Author> getAll();
    Author getById(Long id);
    void deleteById(Long id);
    List<Author> getByAuthorName(String authorName);
}
