package com.example.testtest.service.author;

import com.example.testtest.models.Author;
import com.example.testtest.repository.AuthorRepository;
import com.example.testtest.service.author.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author add(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> getByAuthorName(String authorName) {
        return authorRepository.getByAuthorName(authorName);
    }
}
