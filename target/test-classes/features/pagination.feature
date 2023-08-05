@regression @ui @login
Feature: Validating Login Functionality
  Background: User log in
    When Validating login functionality with valid credentials
    When User log in with username "student@mindtekbootcamp.com" and password "ilovejava"
    Then User is successfully logged in

  @smoke @pagination
  Scenario: Verify pagination functionality
    When User clicks on companies it will show table
    Given User on the table page
    When user clicks the ">" pagination button
    Then User should be on the last page
    And all tags should be reset

  Scenario: Testing single arrow "<" Btn
