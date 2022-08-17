package com.godeltech.mastery.CucumberBooks.web.controller;

import com.godeltech.mastery.CucumberBooks.model.Book;
import com.godeltech.mastery.CucumberBooks.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService bookService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book findById(
            @PathVariable Long id) {
        return bookService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Book update(
            @Valid @RequestBody Book book) {
        return bookService.update(book);
    }

}
