Feature: Verify API response status

  Scenario: Verify status code and status returned by the API
    Given the API is available
    When the user makes a GET request
    Then the response status code should be 200
    And the response body should contain a valid status
