package com.example.testtest.repository;

import com.example.testtest.models.Genre;
import com.example.testtest.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
