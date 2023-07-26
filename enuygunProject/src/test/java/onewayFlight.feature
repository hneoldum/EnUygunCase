
Feature: onewayFlight
  Scenario: Search Domestic One Way Flight

    Given Navigate to Website
    And Type Departure City "Ankara"
    And Type Destination City "İstanbul"
    And Select Departure Date "20 Eylül 2023"
    And Select "Student" Passenger 2
    When Click Find Deals Button
    Then Verify the Search Page



  Scenario: First Video
    Given Navigate to Website "https://www.youtube.com/"
    And Click The First Video