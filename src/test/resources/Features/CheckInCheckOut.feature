Feature:

  Background:
    Given user is on login page

  @OfficIn
  Scenario Outline: Check the functionality of the CheckInCheckOut
    Then TSM user Logs in to the application
    Then user naviagtes to CheckinCheckout page
    Then user selects the visittype as <visittype> and click on office in
    Then user clicks on officein
    Examples:
      | visittype    |
      | office visit |

