Feature: Verify auto complete search result

  Background:
    Given I am on heroku home page

  @heroku-topbar
  Scenario: Verify search result

    When I click on top search bar
    And I search on top search bar with text ios
    Then I verify Title: I will teach you IOS displayed as result


  @heroku-count
  Scenario: Verify total number of posts on home page (heroku)

#  Given I am on heroku home page

    Then I verify 94 total post is displayed
    And I verify all post has price tag
    And I verify all post has title
    And  I verify all post has displayed image
