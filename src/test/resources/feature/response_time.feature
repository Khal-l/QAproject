Feature: Verify API response time

  Scenario: Verify API response time is not less than 3 seconds
    Given the API is available
    When the user makes a GET request
    Then the response status code should be 200
    And the response time should not be less than 3 seconds
