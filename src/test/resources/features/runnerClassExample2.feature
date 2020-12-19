Feature:  Amazon.com Testing

  @amazon
  Scenario: Amazon Seach Result Number
    When user navigates to web site "amazon.com"
    Then user searches "Iphone" on search bar
    And user validates the number of search results on web site
