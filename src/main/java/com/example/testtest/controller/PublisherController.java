package com.example.testtest.controller;

import com.example.testtest.models.Publisher;
import com.example.testtest.service.PublisherServiceImpl;
import com.example.testtest.shared.Messages;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/publisher/")
public class PublisherController {
    private final PublisherServiceImpl publisherService;

    public PublisherController(PublisherServiceImpl publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody Publisher publisher) {
        publisherService.add(publisher);
        return ResponseEntity.ok(Messages.PUBLISHER_CREATED);
    }

    @GetMapping("getAll")
    public List<Publisher> getAll() {
        return publisherService.getAll();
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(publisherService.getById(id));
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        publisherService.deleteById(id);
        return ResponseEntity.ok(Messages.PUBLISHER_DELETED);
    }

    @GetMapping("getByPublisherName")
    public List<Publisher> getByPublisherName(@RequestParam String publisherName) {
        return publisherService.getByPublisherName(publisherName);
    }
}
