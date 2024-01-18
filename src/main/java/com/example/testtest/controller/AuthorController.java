package com.example.testtest.controller;

import com.example.testtest.models.Author;
import com.example.testtest.service.AuthorServiceImpl;
import com.example.testtest.shared.Messages;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/author/")
public class AuthorController {
    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody Author author) {
        authorService.add(author);
        return ResponseEntity.ok(Messages.AUTHOR_CREATED);
    }

    @GetMapping("getAll")
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getById(id));
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        authorService.deleteById(id);
        return ResponseEntity.ok(Messages.AUTHOR_DELETED);
    }

    @GetMapping("getByAuthorName")
    public List<Author> getByAuthorName(@RequestParam String authorName) {
        return authorService.getByAuthorName(authorName);
    }

}
