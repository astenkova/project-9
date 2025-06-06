Feature: Users should be able to log in with valid credentials
  should land on the home page after successful login.

  Background: User navigates to the URL
    Given user on the login page


  Scenario: User entered valid login credentials, so user was able to see the home page after successful login.
    When user entered valid username
    And entered valid password
    And clicked on login button
    Then User successfully logged in

  @wip
  Scenario: User entered invalid login credentials. Message should be displayed for invalid login attempt.
    When user entered invalid username
    And entered invalid password
    And clicked on login button
    Then Incorrect login or password message popped up