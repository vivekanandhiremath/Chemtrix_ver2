Feature: visit planning

  @CreateVisitPlanning
  Scenario Outline: Create visit planning
    Given user is on login page
    Then user Logs in to the application
    Then user navigates to visit planning dashboard and click on create vsisit planning button
    Then user fills the visit planning details with customer type <customertype> customer name <customername>, phone number <phno>, email <email>, address <address>, visit date <visitdate>, visit time <visittime>, purpose of visit <purposeofvisit>, and remarks <remarks>
    Then user logs out of application
    Examples:
      | customertype | customername | phno       | email                 | address    | visitdate  | visittime | purposeofvisit | remarks |
      | sl           | 2100         | 1234567890 | Vivekananda@gmail.com | Coimbatore | 30/08/2024 | 20:30     | Salesorder     | Remarks |


    @ApproveVisitPlanningByBM
    Scenario Outline: Approve VisitPlanning
      Given user is on login page
      Then BM Logs in to the application
      Then user navigates to visit planning dashboard
      Then user filter record as <filtertype> for cvpno as <cvpno> and click on view button
      Then user approves the visit plan
      Examples:
       |filtertype| cvpno |
        |cvpno|   6171    |

