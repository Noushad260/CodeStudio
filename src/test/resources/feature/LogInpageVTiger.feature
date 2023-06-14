
Feature: Log_In Page Of VTiger CRM
 
 @Sanity
  Scenario: Title of your scenario
    Given Launch The Browser
    And Navigate URL "http://localhost:8888/"
    When Insert Valid Cradencial username "admin" password "razamd260@G"
    And  Click On Login Icon
    Then HomePage Should Be Displayed
    And  Logout Application

 
