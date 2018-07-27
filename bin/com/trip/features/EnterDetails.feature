Feature: Enter the details in the home page

Scenario: Enter details to search flight for one way trip
Given I am on ClearTrip search flights page
When I enter Source City
And I enter Destination City
And I select the journey date
And I select the number of adults
And I select the number of children
And I select the number of infants
And I tap on Submit button
Then I navigate to Search Results Page
