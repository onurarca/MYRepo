@etsy
Feature: Ets.com search result

  Scenario: Getting prices for "Antique Jeweleries"
    When user navigate to "etsy.com"
    And searches for "antique jewelry"
    Then confirms total prices are bigger than 0

