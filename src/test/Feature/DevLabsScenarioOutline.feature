Feature: validate Docker Home Page Functionalities
  Scenario Outline: Docker Home Page validation
    Then user validate docker home page title as "<TITLE>"
    And user validate header menu as option as "<menu>"
    Then user validate Sign In button
    And user validate Get Started button
    Then user scroll to footer section
    And user validate all social media options
    Then user clicks on twitter logo
    And user validate URL is having text as "<text>"
    And user close twitter child tab

    Examples:
    |TITLE|menu|text|
    |Docker: Accelerated Container Application Development|Products|docker|

