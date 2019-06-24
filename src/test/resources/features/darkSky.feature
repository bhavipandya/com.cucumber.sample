@web @regression @darkSky

  Feature: darkSky feature

    Background:
      Given I am on DarkSky Home Page
      @darkSky-1
    Scenario: Verify invalid signup error message
      When I am on the darksky homepage page
      And  I am on the darksky Register page
      When I click on Register button
      Then I verify am on RegisterPage by verifying Registerlink


        @darkSky-2
      Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
          Given I am on DarkSky Home Page
        Then I verify current temp is not greater or less then temps from daily timeline

          @darkSky-3
          Scenario: Verify individual day temp timeline
            Given I am on DarkSky Home Page
            When I expand todays timeline
            Then I verify lowest and highest temp is displayed correctly

     @darkSky-4
    Scenario: Verify timline is displayed in correct format
      Given I am on DarkSky Home Page
      Then I verify timeline is displayed with two hours incremented