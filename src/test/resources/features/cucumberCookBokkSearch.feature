Feature: Counting links in google
  Scenario: Count link numbers for "Cucumber Cookbook"
    When user navigates to "google.com" website
    Then searches for "cucumber cookbook" in google
    And gets the number of links provided on the first and second pages.