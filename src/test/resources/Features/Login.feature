Feature: Login Test

  @Login @smoke
  Scenario Outline: Testing login functionality
    Given user is on login page
    Then user Enters username and password from <key>
    Then user logs out of application
    Examples:
      | key   |
      | login |