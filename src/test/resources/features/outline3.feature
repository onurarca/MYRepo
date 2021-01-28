Feature: login functionality

  @login
  Scenario Outline: negative login
    Given user navigated to demo.openmrs.org
    When user tries to login with "<Username>", "<Password>","<LoginType>"
    And user gets error message "<ErrorMessage>"
    Examples:
      | Username | Password | LoginType         | ErrorMessage                                 |
      | admin    | Admin123 | Registration Desk | Invalid username/password. Please try again. |
      | admin    | Admin123 | Registration Desk | Invalid username/password. Please try again. |
      | admin    | Admin123 | Registration Desk | Invalid username/password. Please try again. |
      | admin    | Admin123 | Registration Desk | Invalid username/password. Please try again. |
      | admin    | Admin123 | Registration Desk | Invalid username/password. Please try again. |