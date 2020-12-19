Feature: MRS patient registration

  @outline2
  Scenario Outline: negative testing
    When user navigates to open MRS home page
    And user los in with following data:
      | departmentName    | username | password |
      | Registration Desk | admin    | Admin123 |
    Then user creates a new patient everytime with following data: "<GivenName>", "<FamilyName>", "<Gender>"
    And with also extra information:"<BirthDay>", "<BirthMonth>", "<BirthYear>"
    And  also address:"<Address>", "<City>", "<State>", "<Country>", and "<PostalCode>", "<PhoneNumber>", "<RelativeName>"
    Then confirms new patient has been registered with "<GivenName>" and "<FamilyName>"
    Examples:
      | GivenName | FamilyName | Gender | BirthDay | BirthMonth | BirthYear | Address  | City       | State       | Country | PostalCode | PhoneNumber | RelativeName |
      | Onur      | Arca       | M      | 13       | 12         | 1993      | AustinTX | Austin     | Texas       | USA     | 78748      | 5552522525  | Andrea Arca  |
      | Jonny     | Walker     | M      |          | 12         | 1993      | AustinTX | Austin     | Texas       | USA     | 78748      | 5552522525  | Andrea Arca  |
      | Jack      | Daniels    | M      | 13       | 12         | 1993      |          | Austin     | Texas       | USA     | 78748      | 5552522525  | Andrea Arca  |
      | Jonny     |            | M      | 11       | 12         |      | AustinTX | Austin     | Texas       | USA     | 78748      | 5552522525  | Andrea Arca  |
      | Jonny     |            | M      | 11       | 12         | 1993      | AustinTX | Austin     | Texas       | USA     | 78748      | 5552522525  | Andrea Arca  |
      |           | Walker     | M      | 10       | 12         | 1993      | AustinTX | Austin     | Texas       | USA     | 78748      | 5552522525  | Andrea Arca  |
      | Jonny     | Walker     | M      | 09       | 12         | 1993      | AustinTX |            | Texas       | USA     | 78748      | 5552522525  | Andrea Arca  |
      | Jonny     | Walker     | M      | 08       | 12         | 1993      | AustinTX | Austin     |             | USA     | 78748      | 5552522525  | Andrea Arca  |
