Feature: Login
  Background:
    Given User is on "sign in" page

  Scenario: User can log in
    When User logs in with valid credentials
    Then User is logged in
    And User is redirected to "my account" page

  Scenario: User cannot log in with wrong password
    When User logs in with wrong password
    Then Login error message is shown: "Authentication failed."
    And User is not logged in

  Scenario: User cannot log in with empty password
    When User logs in with empty password
    Then Login error message is shown: "Password is required."
    And User is not logged in

  Scenario: User cannot log in with empty email
    When User logs in with empty email
    Then Login error message is shown: "An email address required."
    And User is not logged in

  Scenario: User cannot log in with invalid email
    When User logs in with invalid email
    Then Login error message is shown: "Invalid email address."
    And User is not logged in

  Scenario: User cannot log in with wrong email
    When User logs in with wrong email
    Then Login error message is shown: "Authentication failed."
    And User is not logged in

  Scenario: User cannot log in with empty credentials
    When User logs in with empty credentials
    Then Login error message is shown: "An email address required."
    And User is not logged in
