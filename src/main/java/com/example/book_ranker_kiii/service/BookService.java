package com.example.book_ranker_kiii.service;


import com.example.book_ranker_kiii.model.Book;
import com.example.book_ranker_kiii.model.Genre;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    Book findById(Long id);

    List<Book> listAll();


    public Book create(String name, LocalDate date, String artist, Genre genre);

    public Book update(Long id, String name, LocalDate date, String artist, Genre genre);

    public Book delete(Long id);

    public Book favourite(Long id);

    public List<Book> filter(String name, LocalDate date, Genre genre);
}
