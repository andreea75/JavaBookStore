package com.example.testtest.repository;

import com.example.testtest.models.BookCategory;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
}
