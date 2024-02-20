package com.example.testtest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
//import jakarta.persistence.*;
import lombok.*;

import javax.persistence.*;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Column(name = "nationality")
    private String nationality;
}
