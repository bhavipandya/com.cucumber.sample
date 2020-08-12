@mobile @mobile-regression @menu
Feature: Menu feature

  @menu-1
  Scenario: Verify sidebar validation
    When I tap on skip button
    And I tap on menu button
    Then I verify sidebar menu is displayed

    @menu-2
    Scenario: Verify Login button
      When I tap on skip button
      And  I tap on menu button
      Then I tap on login button
      And I enter username
      And I enter password
      And I click on Login button
      And I tap on menu button
      Then I tap on Logout
      And I tap on menu button
      Then I verify Lojin option exists



   @menu-3
  Scenario: Verify user should be able to view default main menu bar items
    Given I am on home page of the app
    When I tap on menu button
    Then I verify default main menu bar fields

    @menu-4
    Scenario: Verify user should be able to slide right on tutorial pages
      Given I am on Splash screen of the ionic conference app
      When I swipe right 3 times on tutorials slides
      Then I verify Continue button is displayed