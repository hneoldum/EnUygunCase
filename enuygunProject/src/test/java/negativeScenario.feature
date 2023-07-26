
Feature: NegativeScenario

Scenario: Search International Flight and  2 Infant - Negative Scenario

Given Navigate to Website
And Type Departure City "Amsterdam"
And Type Destination City "Berlin"
And Select Departure Date "10 Temmuz 2023"
And Select Return Date "20 Temmuz 2023"
And Select "Adult" Passenger 1
And Select "Infant" Passenger 2
When Click Find Deals Button
Then Verify the Search Page