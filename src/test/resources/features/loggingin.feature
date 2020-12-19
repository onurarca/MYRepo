Feature: login to demo.openmrs page


  @neverFails
  Scenario: loging in
    When user navigates to OpenMRS web site
    And user enters username "admin" and password "Admin123" and logs in
    Then Message contains "Coyote Coyote (admin)"

  Scenario: Find patient
    Given  user logged in to demo.openmrs.org
    When user searches for 123 patient
    Then no records found


  @datatable
  Scenario: Login with cucumber datatable
    When user navigates to open MRS home page
    And user los in with following data:
      | departmentName    | username | password |
      | Registration Desk | admin    | Admin123 |
    Then  user is logged in as "Super User (admin)"

  @datatable2
  Scenario: Register a patient

    When user registers a new patient with following information:
      | GivenName | FamilyName | Gender | BirthDay | BirthMonth | BirthYear | Address  | City   | State | Country | PostalCode | PhoneNumber | RelativeName |
      | Onur      | Arca       | M      | 13       | 12         | 1993      | AustinTX | Austin | Texas | USA     | 78748      | 5552522525  | AndreaArca   |
    Then new patient is registered


  @datatable3
  Scenario: Login with cucumber datatable (Variant2)
    When user navigates to open MRS home page
    And user los in with following data with different table:
      | departmentName | Registration Desk |
      | username       | admin             |
      | password       | Admin123          |
    Then  user is logged in as "Super User (admin)"

  @datatable4
  Scenario: login with map style data table
    Given user logged in to demo.openmrs.org as admin
    And user registers a new patient with the following data:
      | GivenName    | Onur       |
      | FamilyName   | Arca       |
      | Gender       | M          |
      | BirthDay     | 13         |
      | BirthMonth   | 12         |
      | BirthYear    | 1993       |
      | Address      | AustinTX   |
      | City         | Austin     |
      | State        | Texas      |
      | Country      | USA        |
      | PostalCode   | 78748      |
      | PhoneNumber  | 5552522525 |
      | RelativeName | Andrea Arca |
    Then new patient is registered

    @outline
    Scenario Outline: Registera patient variant 2
      Given user is logged in to demo.openmrs.org as admin
      When user creates a new patient with following data: "<GivenName>", "<FamilyName>", "<Gender>"
      And with extra information:"<BirthDay>", "<BirthMonth>", "<BirthYear>"
      And  with address:"<Address>", "<City>", "<State>", "<Country>", and "<PostalCode>"
      Then new patient has been registered with "<GivenName>" and "<FamilyName>"
      And address of the new patient is "<Address>", "<City>", "<State>"
      Examples:
        | GivenName | FamilyName | Gender | BirthDay | BirthMonth | BirthYear | Address  | City   | State | Country | PostalCode | PhoneNumber | RelativeName |
        | Onur      | Arca       | M      | 13       | 12         | 1993      | AustinTX | Austin | Texas | USA     | 78748      | 5552522525  | Andrea Arca   |
        | Jonny     | Walker       | M      | 13       | 12         | 1993      | AustinTX | Austin | Texas | USA     | 78748      | 5552522525  | Andrea Arca   |
        | Jack      | Daniels       | M      | 13       | 12         | 1993      | AustinTX | Austin | Texas | USA     | 78748      | 5552522525  | Andrea Arca   |


