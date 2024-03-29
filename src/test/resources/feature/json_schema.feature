Feature: Verify API response matches JSON schema

  Scenario: Verify API response matches JSON schema
    Given the API is available
    When the user makes a GET request
    Then the response status code should be 200
    And the response body should match the JSON schema
