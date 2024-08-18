Feature: validate devlab homepage scenarios


  Scenario: validate devlab homepage top menu options
    When user launch devlab application
    Then user should navigate to homepage
    And user validate devlab logo
    And user validate top menu options
    Then user close devlab application