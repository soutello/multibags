Feature: Change Password

  Scenario: Successful change password
    Given user fill form with new data
    When user clicks create account
    Then the page is redirected to customer dashboard
    When user go to change password page
    And user fill password change form
    And user clicks change password
    Then change password success message is displayed

  Scenario: new password mismatch
    Given user fill form with new data
    When user clicks create account
    Then the page is redirected to customer dashboard
    When user go to change password page
    And user fill password change form with new password different than repeat password
    Then both password must match message must be displayed