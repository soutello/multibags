Feature: Change Password

  Scenario: Successful change password
    Given user fill sign in form with new data
    When user clicks create account button
    Then successful login
    When user go to change password page
    And user fill password change form
    And user clicks change password
    Then change password success message is displayed

  Scenario: new password mismatch
    Given user fill sign in form with new data
    When user clicks create account button
    Then successful login
    When user go to change password page
    And user fill password change form with new password different than repeat password
    Then both password must match message must be displayed