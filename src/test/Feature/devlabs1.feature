Feature: validate Login
  Scenario: Validate login
    When user clicks on Login button
    Then user fills in username and email
    Then user submits info
    Then server validates info