Feature:  Google.com Testing
  @Background:

  @google
  Scenario: Google Seach Result Number
    When user navigates to "google.com"
    Then user searches for "Cucumber"
    And user validates the number of search results

    @test
    Scenario: Negative search Scenerio
      When user navigates to "google.com"
      And user enters "java basics" in search field
      Then the result page will not have topics about "python"