package com.example.book_ranker_kiii.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    Long id;

    String name;

    LocalDate dateWritten;

    String artistName;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    Integer num_favourites;

    public Book() {

    }

    public Book(String name, LocalDate date, String artistName, Genre genre, Integer num) {
        this.name = name;
        this.dateWritten = date;
        this.artistName = artistName;
        this.genre = genre;
        this.num_favourites = num;
    }
}
