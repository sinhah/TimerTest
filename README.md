# TimerTest
Timertest

Timertest is a behavior driven development (BDD) approach to write automation test script to test Web (e.ggtimer.com). It enables you to write and execute automated acceptance tests.

Pre-requisites

Java JDK
Eclipse
Eclipse Plugins 
    Cucumber
    Selenium
    
Setting up selenium-cucumber-java

Install Java and set path.
Install Eclipse
Add all the Selenium and JUnit jar files to the project
Clone respective repository or download zip. 

Setup:
Clone the project from git
Launch Eclipse
click on File -> Import
Click on Browse and navigate to git directory and select folder

Framework Description:

page object pattern is used to have reusable WebElements/small helper methods seperated from actual test classes and give the opportunity to have nice structured and easily readable tests

resources\features - all the cucumber features files (TimerHomePage.feature ext) goes here.
src/ stepDefinitions - you can define step defintion under this package for your feature steps.
src\TestRunners - this package contains cucumber runner (TestRunner_Timer) where you can configure your glue code location (step defintions).

Executing Tests:
To run test suite,
select TestRunners.java under folder src
Click on Run menu option and select run as JUnit Tests
