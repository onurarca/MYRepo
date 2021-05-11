Feature: exercise

  @pet1
  Scenario: exercise1
    When user creates a pet with given <id> <name> and <status>
      | id    | name | status   |
      | 15915 | Reks | good dog |
    Then user verifies the pet is created.
    And user deletes the pet.