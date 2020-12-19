Feature: EspoCRM Testing

  @EspoCRMDT1
  Scenario: Acceptance Criteria 1
    Given the user navigate the "https://demo.espocrm.com/?lang=en_US#"
    When the user open the home page
    Then the user should see the function names
      | Home          |
      | Accounts      |
      | Contacts      |
      | Leads         |
      | Opportunities |
      | Reports       |
      | Quotes        |
      | Sales Orders  |
      | Invoices      |
      | Products      |
      | Emails        |
      | Cases         |
      | Calendar      |
      | Tasks         |


  @EspoCRMOutline
  Scenario Outline: Acceptance Criteria 2
    Given the user navigate the "https://demo.espocrm.com/?lang=en_US#"
    When the user open the Accounts
    Then the user clicks the Create Account button
    And the user create 4 new account with "<Name>", "<Email>", "<Phone>", "<Street>", "<City>", "<State>", "<Zip>", "<Country>", "<Type>", "<Industry>"
    And the user validate the new users is created  with "<Name>", "<Email>", "<Phone>", "<Type>", "<Industry>"
    Examples:
      | Name        | Email            | Phone      | Street | City   | State | Zip   | Country | Type     | Industry |
      | Onur Arca   | onur@gmail.com   | 5552552525 | 10101  | Austin | Tx    | 78732 | USA     | Investor | Banking  |
      | Mehmet Arca | mehmet@gmail.com | 2222552525 | 101 ln | Austin | Tx    | 78758 | USA     | Customer | Computer |
      | Onur Blue   | blue@gmail.com   | 5555552525 | 0101   | Austin | Tx    | 78744 | USA     | Partner  | Creative |
      | Blue Arca   | arca@gmail.com   | 5552666525 | 101    | Austin | Tx    | 78736 | USA     | Reseller | Culture  |


  @EspoCRM
  Scenario: Acceptance Criteria 3
    Given the user navigate the "https://demo.espocrm.com/?lang=en_US#"
    When user clicks the hamburger button
    Then user click on the treedor '...' at the end
    And user click the users
    Then the user should see given names and emails
      | Admin           | espocrm.demo@gmail.com              |
      | Ben Parter      | ben.parter@example.com.ko           |
      | Bill Chan       | bill_chan@example-demo.so           |
      | Brendon Lewis   | brendon.lewis@re-example.org        |
      | Emma Bard       | emma_bard@rio.demo.su               |
      | Gabliel Brie    | gabrielbrie@exmpl.org.pi            |
      | Jake Forester   | jake_forester@example-espo.demo.com |
      | JGili_user1 .   | jgili_user1@gmail.com               |
      | Jim Williams    | jim_williams@example.com.ca         |
      | Rebecca Maer    | rebecca.maer@demo_exmpl.org          |
      | Richard Pan     | richard_pan@read.exmpl-dd.com       |
      | Thomas Peterson | thomas.peterson@demo-user.exmpl.com |

