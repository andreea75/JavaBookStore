package com.example.testtest.service;

import com.example.testtest.models.Publisher;
import com.example.testtest.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService{
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher add(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getById(Long id) {
        Optional<Publisher> publisher = publisherRepository.findById(id);
        return publisher.orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        publisherRepository.deleteById(id);
    }

    @Override
    public List<Publisher> getByPublisherName(String publisherName) {
        return publisherRepository.getByPublisherName(publisherName);
    }
}
