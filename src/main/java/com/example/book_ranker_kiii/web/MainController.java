package com.example.book_ranker_kiii.web;

import com.example.book_ranker_kiii.model.Book;
import com.example.book_ranker_kiii.model.Genre;
import com.example.book_ranker_kiii.service.BookService;
import com.example.book_ranker_kiii.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class MainController {

    private final BookService bookService;
    private final ClientService clientService;

    @GetMapping(value = {"/", "/books"})
    public String showList(Model model, @RequestParam(required = false) String artistName, @RequestParam(required = false) LocalDate publicationYear,@RequestParam(required = false)  Genre genre) {
        List<Book> books;
        if(Objects.equals(artistName, "")) {
            artistName = null;
        }
        if(artistName != null || publicationYear != null || genre != null) {
            books = this.bookService.filter(artistName, publicationYear, genre);

        }
        else {
            books = this.bookService.listAll();
        }

        model.addAttribute("books", books);
        model.addAttribute("genres", Genre.values());
        model.addAttribute("artists", this.bookService.listAll().stream().map(Book::getArtistName).collect(Collectors.toList()));
        model.addAttribute("clients", this.clientService.listAll());

        return "list";
    }

    @GetMapping("/books/add")
    public String showAdd(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("genres", Genre.values());


        return "form";
    }

    @PostMapping("/books/")
    public String doAdd(
            @RequestParam String name,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateWritten,
            @RequestParam String artistName,
            @RequestParam Genre genre) {

        this.bookService.create(name, dateWritten, artistName, genre);
        return "redirect:/books";
    }

    @GetMapping("/books/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("book", this.bookService.findById(id));
        model.addAttribute("genres", Genre.values());

        return "form";
    }

    @PostMapping("/books/{id}")
    public String doEdit(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateWritten,
            @RequestParam String artistName,
            @RequestParam Genre genre) {

        this.bookService.update(id ,name, dateWritten, artistName, genre);
        return "redirect:/books";
    }

    @PostMapping("/books/{id}/delete")
    public String doDelete(
            @PathVariable Long id) {

        this.bookService.delete(id);
        return "redirect:/books";
    }


}
