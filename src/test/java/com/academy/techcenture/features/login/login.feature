Feature: SauceLabs Login Feature

  Background: Login Background Steps
    Given user is on the home page

  Scenario: Successful login
    When user enters a valid username "standard_user"
    And user enters a valid password "secret_sauce"
    And user enters on the login button
    Then user should be logged in successfully

  Scenario: Invalid credentials
    When user enters a valid username "standard_user"
    And user enters a invalid password "invalid_sauce"
    And user enters on the login button
    Then user should see error message

