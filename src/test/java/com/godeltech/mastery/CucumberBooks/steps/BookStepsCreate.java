package com.godeltech.mastery.CucumberBooks.steps;

import com.godeltech.mastery.CucumberBooks.model.Book;
import com.godeltech.mastery.CucumberBooks.service.BookService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookStepsCreate {
    @Autowired
    BookService bookService;
    List<Book> books;

    @Given("I create an book named {string} and store to database")
    public void iCreateAnBookNamedAndStoreToDatabase(String arg0) {
        Book book = new Book();
        book.setName(arg0);
        bookService.save(book);
    }

    @When("I search for that book by the name {string}")
    public void iSearchForThatBookByTheName(String arg0) {
        books = bookService.findBookByName(arg0);
    }

    @Then("I should find at least one result")
    public void iShouldFindAtLeastOneResult() {
        Assertions.assertTrue(books.size() > 0);
    }
}
