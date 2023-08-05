 @regression @ui @MB-70
Feature: Validating Login Functionality
 @smoke @loginPositive
  Scenario: Validating login functionality with valid credentials
    Given User navigates to application
    When User logs in with username "Tester" and password "test"
    Then User is successfully logged in and  land on the home page
 @smoke @loginNegative @MB-70
  Scenario: Validating login functionality with invalid credentials
    Given User navigates to application
    When User logs in with username "Tester" and password "Testers"
    Then User validates error messages "Invalid Login or Password."