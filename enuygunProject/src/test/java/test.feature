
Feature: Test
  Scenario: Search Domestic Flight and Passengers

    Given Navigate to Website
    And Type Departure City "Adana"
    And Type Destination City "İzmir"
    And Select Departure Date "26 Haziran 2023"
    And Select Return Date "30 Haziran 2023"
    And Select "Child" Passenger 1
    And Select "Infant" Passenger 1
    And Select "Senior" Passenger 1
    And Select "Student" Passenger 1
    And Select "Adult" Passenger 2
    When Click Find Deals Button
    Then Verify the Search Page


  Scenario: QRTst
    * Navigate to Website
    * Type Departure City "Adana"
    * Type Destination City "İzmir"
    * Select Departure Date "26 Haziran 2023"
    * Select Return Date "30 Haziran 2023"

