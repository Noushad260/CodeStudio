
Feature: Customer
 
  Background: Common steps
    Given Launch The Browser
    And Navigate URL "http://localhost:8888/"
    When Insert Valid Cradencial username "admin" password "razamd260@G"
    And  Click On Login Icon
  
   @Smoke
   Scenario: Title of your scenario
    Then click on Lead Module
    And Create lead 
    And Insert lastname "Ansari"  company "TestYantara"
    And Save Lead 
    And  Logout Application

   @Sanity
   Scenario: Title of your scenario
    Then click on Organizations Module
    And Create Organizations 
    And Insert Organizations name "Noushad"  
    And Save organizations
    And  Logout Application