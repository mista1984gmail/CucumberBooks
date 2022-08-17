package com.godeltech.mastery.CucumberBooks.steps;

import com.godeltech.mastery.CucumberBooks.model.Book;
import com.godeltech.mastery.CucumberBooks.service.BookService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookStepsDelete {
    @Autowired
    BookService bookService;
    List<Book> books;

    @Given("I create book named {string} and store to database")
    public void createAnBookNamedAndStoreToDatabase(String arg0) {
        Book book = new Book();
        book.setName(arg0);
        bookService.save(book);
    }
    @When("I search book by the name {string}")
    public void searchForThatBookByTheName(String arg0) {
        books = bookService.findBookByName(arg0);
    }

    @When("I delete book name {string} from database")
    public void deleteForThatBookByTheName(String arg0) {
        books = bookService.findBookByName(arg0);
        bookService.delete(books.get(0).getId());
    }
    @Then("I should not find at this book with name {string} anymore")
    public void shouldNotFindNoResult(String arg0) {
        books = bookService.findBookByName(arg0);
        Assertions.assertTrue(books.isEmpty());
    }
}
