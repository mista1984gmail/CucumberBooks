Feature: Create book
  Scenario: Create book and save to database
    Given I create an book named "Peace and War" and store to database
    When I search for that book by the name "Peace and War"
    Then I should find at least one result