Feature: Login Test

  @Login @smoke
  Scenario Outline: Testing login functionality
    Given user is on login page
    Then user Enters username and password from <key>
    Then user navigates to visit planning dashboard and click on create vsisit planning button
    Examples:
      | key   |
      | login |