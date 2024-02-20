package com.example.testtest.models;

import com.example.testtest.shared.Messages;
import javax.persistence.*;
import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@Entity
@Table(name = "book_category")
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
