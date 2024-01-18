package com.example.testtest.service;

import com.example.testtest.models.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher add(Publisher publisher);
    List<Publisher> getAll();
    Publisher getById(Long id);
    void deleteById(Long id);
    List<Publisher> getByPublisherName(String publisherName);
}
