Feature: Verify number of currency pairs

  Scenario: Verify 162 currency pairs are returned by the API
    Given the API is available
    When the user makes a GET request to retrieve all currency pairs
    Then the response status code should be 200
    And the number of currency pairs returned should be 162
