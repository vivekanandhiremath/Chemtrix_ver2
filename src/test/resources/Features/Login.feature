Feature: Login Test

  @Login @smoke
  Scenario Outline: Testing login functionality
    Given user is on login page
    Then user logs in to application <key>
    Examples:
      | key   |
      | login |