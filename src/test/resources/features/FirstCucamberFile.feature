 Feature: Techtorial academy login tests

  @neverFails
  Scenario: Happy path(successfull) sign in
    When user navigates to Techtorial academy home page
    And user uses "admin" as username and "admin123" as password
    Then user logged in
    