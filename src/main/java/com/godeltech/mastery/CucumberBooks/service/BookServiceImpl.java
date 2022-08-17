package com.godeltech.mastery.CucumberBooks.service;

import com.godeltech.mastery.CucumberBooks.model.Book;
import com.godeltech.mastery.CucumberBooks.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var type = bookRepository.findById(id).get();
        bookRepository.delete(type);
    }

    @Override
    @Transactional
    public Book update(Book book) {
        var type = bookRepository.findById(book.getId()).get();
        type.setName(book.getName());

        return bookRepository.save(type);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> findBookByName(String name) {
        return bookRepository.findBookByName(name);
    }
}
