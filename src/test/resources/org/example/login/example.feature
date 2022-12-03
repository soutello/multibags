Feature: Login

  Scenario: Login error message
    Given user input unregistered email in login page
    When I click sign in button
    Then login failed error message is displayed
