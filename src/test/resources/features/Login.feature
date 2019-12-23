Feature: Login

  Background:
    Given User is on "sign in" page

  Scenario: User can log in
    When User logs in with valid credentials
    Then User is logged in
    And User is redirected to "my account" page

  Scenario Outline: User cannot log in with wrong credentials
    When User logs in with "<email>" and "<password>"
    Then Login error message is shown: "<message>"
    And User is not logged in
    Examples:
      | email                                     | password        | message                    |
      | correct-email                             | WrongPassword1! | Authentication failed.     |
      | correct-email                             |                 | Password is required.      |
      |                                           | ValidPassword1! | An email address required. |
      | invalid-email                             | ValidPassword1! | Invalid email address.     |
      | example-of-wrong-email@konradfilipiak.com | ValidPassword1! | Authentication failed.     |
    