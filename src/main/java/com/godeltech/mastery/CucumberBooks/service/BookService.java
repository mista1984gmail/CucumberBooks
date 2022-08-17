package com.godeltech.mastery.CucumberBooks.service;

import com.godeltech.mastery.CucumberBooks.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book save(Book book);

    void delete(Long id);

    Book update(Book book);

    Book findById(Long id);
    List<Book> findBookByName(String name);
}
