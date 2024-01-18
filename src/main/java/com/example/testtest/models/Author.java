package com.example.testtest.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@ToString
@Getter
@Setter
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authorName")
    private String authorName;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "nationality")
    private String nationality;
}
