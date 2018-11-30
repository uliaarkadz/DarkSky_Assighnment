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

  @heroku-invalid-email
  Scenario Outline: Verify invalid email on registration
    Given I am on Registration page
    When I enter name as testuser email as <email> password as test12345
    And I click 'submit' button
    Then  I verify invalid email address

    Examples:
      | email              |
      | test.com           |
      | test@test@test.com |

  @heroku-newuser
  Scenario: Verify a new user can register with a valid email address
    Given I am on Registration page
    When I enter name as testuser email as test@test.com password as test12345
    And I click 'submit' button
    Then  I am signed-in as a new user
