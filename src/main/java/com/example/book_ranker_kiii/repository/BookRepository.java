package com.example.book_ranker_kiii.repository;

import com.example.book_ranker_kiii.model.Book;
import com.example.book_ranker_kiii.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    List<Book> findByGenre(Genre genre);
    List<Book> findByDateWrittenBefore(LocalDate date);
    List<Book> findByArtistName(String name);
    List<Book> findByGenreAndDateWrittenBefore(Genre genre, LocalDate date);
    List<Book> findByGenreAndArtistName(Genre genre, String name);
    List<Book> findByDateWrittenAndArtistName(LocalDate date, String name);
    List<Book> findByGenreAndDateWrittenBeforeAndArtistName(Genre genre, LocalDate date, String name);


}
