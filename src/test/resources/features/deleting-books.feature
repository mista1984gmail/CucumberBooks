Feature: Delete book
  Scenario: Create book and delete from database
    Given I create book named "Peace and War" and store to database
    When I search book by the name "Peace and War"
    When I delete book name "Peace and War" from database
    Then I should not find at this book with name "Peace and War" anymore