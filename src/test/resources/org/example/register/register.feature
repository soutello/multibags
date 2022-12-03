Feature: Register

  Scenario: Successful register
    Given user fill form with new data
    When user clicks create account
    Then the page is redirected to customer dashboard

  Scenario: User already exists
    Given user fill form with already registered email
    When user clicks create account
    Then an error message is displayed