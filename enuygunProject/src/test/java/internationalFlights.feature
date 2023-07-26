Feature: InternationalFlights

Scenario: Search International Flight

Given Navigate to Website "https://www.enuygun.com/"
And Type Departure City "Amsterdam"
And Type Destination City "Berlin"
And Select Departure Date "6 Haziran 2023"
And Select Return Date "15 Haziran 2023"
And Select "Adult" Passenger 3
When Click Find Deals Button
Then Verify the Search Page



  Scenario: Search International Flight

    Given Navigate to Website "https://www.enuygun.com/"
    And Click The First Video