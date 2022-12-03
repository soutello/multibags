Feature: Change Password

  Scenario: Successful change password
    Given user log in
    And user fill form with new password
    When user clicks change password
    Then change password success message is displayed
    When user changes password back to old
    Then change password success message is displayed