@regression @ui @etsy
Feature: Validating Search Functionality
  # Background will run below once for Scenario:
  Background: Setup for Etsy tests
  Given User navigates to Etsy application
    When User searches "carpet"
@itemDescription
  Scenario: Validating search result matches with the searched item
    Then  User Validates search result contains
      | carpet | rug | turkish | persian |

  # The values above are in a DAtaTable format. @Then step will accept values that are
  #below in pipes
  @priceRange
  Scenario:Validating price range functionality for searched item
    And User selects price range over 1000
    Then User Validates price range for items over 1000.00
