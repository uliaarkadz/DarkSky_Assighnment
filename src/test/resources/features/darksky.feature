Feature: Verify current temperature

  Background:
    Given I am on darksky home page

  @darksky-temperature
  Scenario: Verify current temperature is between low and high value

    When Clear search text field
    And Enter zip code into the search field as 11024
    And Click on search magnifying glass
    Then Verify current temperature is between low and high value

  @darksky-timeline
  Scenario: Verify timeline is displayed in correct format

#   Given I am on darksky home page
    Then I verify timeline is displayed with 2 hours incremented

  @darksky-day-temp-timeline
  Scenario: Verify individual day temp timeline

#    Given I am on Darksky Home Page
    When I expand todays timeline
    Then I verify lowest and highest temp is displayed correctly

  @darksky-time-machine
  Scenario: Verify Time Machine Calendar
    When I click on Time Machine
    Then I verify date is selected to todays date

