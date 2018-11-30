Feature: Verify auto complete search result

  Background:
    Given I am on heroku home page

  @heroku-topbar
  Scenario: Verify search result

    When I click on top search bar
    And I search on top search bar with text ios
    Then I verify Title: I will teach you IOS displayed as result
