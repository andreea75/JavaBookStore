package com.example.testtest.models;

import javax.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@Entity
@Table(name = "book_details")
public class BookDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
