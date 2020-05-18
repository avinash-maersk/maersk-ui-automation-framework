#Author: avinash.m@maersk.com
@Maersk_Core_Values
Feature: Launch Maersk portal and read core values of Maersk
  @login
  Scenario: Launch browser and read core values of Maersk
    Given user launched "chrome" browser for the brand "MAERSK" in the environment "PRODUCTION"
    And click on Allow All button from pop up
    When click on About us link from dashboard
    And click on Our Core values link
    Then user should be able to view Core values of maersk