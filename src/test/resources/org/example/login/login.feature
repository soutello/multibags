Feature: Login

  Scenario: Login error message
    Given user input unregistered email in login page
    When user clicks sign in button
    Then login failed error message is displayed

    Scenario: Login sucess
    Given user input registered email in login page
    When user clicks sign in button ok
    Then login sucess  