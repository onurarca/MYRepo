Feature: Google search results test

  Scenario: Entering data to Google's search bar
    When User navigates to google
    And enters "vehicle" word to searchbar
    Then clicks on search button

