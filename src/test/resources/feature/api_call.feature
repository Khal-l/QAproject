Feature: Verify API call returns valid price

  Scenario: Verify successful API call and valid price returned
    Given the API is available
    When the user makes a GET request to retrieve the price
    Then the response status code should be 200
    And the response body should contain a valid price
