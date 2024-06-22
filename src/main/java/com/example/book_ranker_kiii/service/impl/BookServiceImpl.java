package com.example.book_ranker_kiii.service.impl;

import com.example.book_ranker_kiii.model.Book;
import com.example.book_ranker_kiii.model.Genre;
import com.example.book_ranker_kiii.repository.BookRepository;
import com.example.book_ranker_kiii.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book create(String name, LocalDate date, String artist, Genre genre) {
        Integer in = 0;
        return this.bookRepository.save(new Book(name, date, artist, genre, in));
    }

    @Override
    public Book update(Long id, String name, LocalDate date, String artist, Genre genre) {
        Book book = this.findById(id);
        book.setName(name);
        book.setGenre(genre);
        book.setArtistName(artist);
        book.setDateWritten(date);

        return this.bookRepository.save(book);
    }

    @Override
    public Book delete(Long id) {
        Book book = this.findById(id);
        this.bookRepository.delete(book);
        return book;
    }

    @Override
    public Book favourite(Long id) {
        Book book = this.findById(id);
        book.setNum_favourites(book.getNum_favourites() + 1);
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> filter(String name, LocalDate date, Genre genre) {
        if (name != null && date != null && genre != null) {
            return this.bookRepository.findByGenreAndDateWrittenBeforeAndArtistName(genre, date, name);
        } else if (name != null && date != null) {
            return this.bookRepository.findByDateWrittenAndArtistName(date, name);
        } else if (name != null && genre != null) {
            return this.bookRepository.findByGenreAndArtistName(genre, name);
        } else if (date != null && genre != null) {
            return this.bookRepository.findByGenreAndDateWrittenBefore(genre, date);
        } else if (name != null) {
            return this.bookRepository.findByArtistName(name);
        } else if (date != null) {
            return this.bookRepository.findByDateWrittenBefore(date);
        } else if (genre != null) {
            return this.bookRepository.findByGenre(genre);
        } else {
            return this.bookRepository.findAll();
        }
    }



}
