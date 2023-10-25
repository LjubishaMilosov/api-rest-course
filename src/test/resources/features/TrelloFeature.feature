Feature: This feature tests Trello API

  Scenario: Add a new list to the test board after changing title
    Given The board exists and contains the correct information
    When User changes the board title to "New title"
    And User checks that the board name was updated to "New title"
    Then User adds a list with title "Example list" to the board