Feature: Verify USD price against AED

  Scenario: Verify USD price is within range against AED
    Given the API is available
    When the user makes a GET request to retrieve the USD price against AED
    Then the response status code should be 200
    And the USD price should be within range 3.6 - 3.7
