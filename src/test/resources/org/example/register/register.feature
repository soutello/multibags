Feature: Register

  Scenario: Successful register
    Given user fill form
    When user clicks create account
    Then the page is redirected to customer dashboard