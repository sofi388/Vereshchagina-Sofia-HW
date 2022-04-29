Feature: User can interact with site

  @first
  Scenario: User can log in and choose checkboxes, radio button and dropdown
    Given I open Home Page "https://jdi-testing.github.io/jdi-light/index.html"
    Then Title of page is "Home Page"
    Given I log in with login: "Roman" and password: "Jdi1234"
    Then User's name is "ROMAN IOVLEV"
    When I click on "DIFFERENT ELEMENTS" in Header Menu->Service
    And I choose checkbox "Water"
    And I choose checkbox "Wind"
    And I choose radio button "Selen"
    And I choose "Yellow" in dropdown
    Then I can see logs with proper text
      | Colors: value changed to Yellow  |
      | metal: value changed to Selen    |
      | Wind: condition changed to true  |
      | Water: condition changed to true |

  @second
  Scenario: User can log in and see User Table
    Given I open Home Page "https://jdi-testing.github.io/jdi-light/index.html"
    And I log in with login: "Roman" and password: "Jdi1234"
    When I click on "USER TABLE" in Header Menu->Service
    Then Title of page is "User Table"
    And 6 Number Type Dropdowns should be displayed on Users Table on User Table Page
    And 6 Usernames should be displayed on Users Table on User Table Page
    And 6 checkboxes should be displayed on Users Table on User Table Page
    And Table should contain following values:
      | Number | User             | Description                       |
      | 1      | Roman            | Wolverine                         |
      | 2      | Sergey Ivan      | Spider Man                        |
      | 3      | Vladzimir        | Punisher                          |
      | 4      | Helen Bennett    | Captain America\nsome description |
      | 5      | Yoshi Tannamuri  | Cyclope\nsome description         |
      | 6      | Giovanni Rovelli | Hulk\nsome description            |
    And droplist should contain values in column Type for user Roman
      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |

  @third
  Scenario: User can log in and select checkbox in User Table
    Given I open Home Page "https://jdi-testing.github.io/jdi-light/index.html"
    And I log in with login: "Roman" and password: "Jdi1234"
    And I click on "USER TABLE" in Header Menu->Service
    When I select 'vip' checkbox for "Sergey Ivan"
    Then 1 log row has "Vip: condition changed to true" text in log section