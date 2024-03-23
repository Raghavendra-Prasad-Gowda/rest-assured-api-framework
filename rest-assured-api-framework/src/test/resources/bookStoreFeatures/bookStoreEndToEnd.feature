Feature: Add and Remove a book from the store for authorized user

  Scenario: Verify If Authorized user can Add and Remove a book from the store.
    Given I Get "valid_credentials" key value from "Authorization.json" file and set it to request body of current request
    Then I Get Authorization Token for the user and set it to request header
    When I get the list of books that are available to add
    Then I set addBook json to current request body
    When I add the book to my reading list
    Then I set removeBook json to current request body
    Then I remove added book from my reading list
    And I Verify if book is removed from the user reading list