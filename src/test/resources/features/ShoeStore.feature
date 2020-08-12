web @regression @ShoeStore

Feature: Shoe Store HomePage feature

  Background:
    Given I am on ShoeStore Home Page
  @ShoeStore-1
  Scenario: Verify Welcome title of Homepage
    Given I am on ShoeStore Home Page
    Then I verify Welcome title on ShoeSore Homepage

  @ShoeStore-2
  Scenario: Verify Month Bar appears on HomePage
    Given I am on ShoeStore Home Page
    Then I Verify the month Bat exists with all the twelve months and All Shows Link

  @ShoeStore-3
  Scenario: Verify All Shoes Link on HomePage
    Given I am on ShoeStore Home Page
    When I click on All Shoes Link
    Then I verify redirection to All Shoes Page

  @ShoeStore-4
  Scenario: Verify Message on Invalid Promotion Code
    Given I am on ShoeStore Home Page
    And I enter invalid data in Promotion Code Textbox
    Amd I click submit Button
    Then I verify Invalid Code Format Message
