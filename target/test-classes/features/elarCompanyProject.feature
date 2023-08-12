@regression @smoke @M88-48
Feature: Testing Add Company functionality

    Scenario: User can add a company
    Given User is on the login page of the application
    When User enters login username "student@mindtekbootcamp.com" and password "ilovejava" and clicks sign in BTN
    Then User is landed to the application page

    When User clicks "Add Company" btn
    And User validates Create company details:
      | Name               | ZRGMTesters Company    |
      | Company            | Broker Company         |
      | Status             | Active                 |
      | MC#                | 123456789              |
      | DOT                | 1234567                |
      | Ifta               | No                     |
      | PhoneNum           | 123-456-7789           |
      | Street             | 12345                  |
      | City               | Naperville             |
      | State              | Illinois               |
      | Zip Code           | 60404                  |
      | Email              | testers56@gmail.com    |
      | Incurance Producer | Bidheifbsd             |
      | ProducerPhoneNum   | 328-676-3687           |
      | Producer Street    | 4564788869             |
      | Producer City      | Illinois               |
      | Producer State     | Illinois               |
      | Producer Zipcode   | 60404                  |
      | Producer email     | bidheifbsd@gmail.com   |
      | Employee Id        |lCLbODJdn5idzvr69zurzg==|
      | Other Licebses     | No                     |
    And User clicks "Add company" button
    Then User should see the created company



