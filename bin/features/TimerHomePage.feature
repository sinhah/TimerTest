Feature: Timer Homepage
This feature verifies the functionality on Timer Homepage

@test
Scenario: Check that main elements on e.ggtimer Homepage are displayed
Given I launch Chrome browser
When I open timer Homepage
Then I verify that the page displays search text box
And the page displays Go button
And I verify the title is "E.gg Timer - a simple countdown timer"
And test passes

@test
Scenario: Validate when timer is expired
Given I am on the Home Page
And I enter the 25 in the text box
And I click on Go Button
When I validate after 25 seconds
Then Timer should stop


@test
Scenario: Validate when timer is running
Given I am on the Home Page
And I enter the 25 in the text box
When I click on Go Button
Then I validate for 25 timer run


