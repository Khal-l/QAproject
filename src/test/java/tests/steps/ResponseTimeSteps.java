package tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResponseTimeSteps {

    private Response response;

    @Given("the API is available")
    public void the_api_is_available4() {
        String apiUrl = "https://open.er-api.com/v6/latest/USD"; // Replace with your API endpoint
        ApiHelper.verifyApiAvailability(apiUrl);
    }

    @When("the user makes a GET request to retrieve the price")
    public void user_makes_get_request4() {
        // Code to make GET request to API
        RequestSpecification request = given();
        response = request.get("https://open.er-api.com/v6/latest/USD");
    }

    @Then("the response status code should be 200")
    public void verify_status_code4() {
        // Code to verify response status code
        int expectedStatusCode = 200; // Define the expected status code
        int actualStatusCode = response.getStatusCode(); // Extract the actual status code from the response object
        assertEquals(expectedStatusCode, actualStatusCode); // Compare the expected and actual status codes
    }

    @Then("the response time should not be less than {int} seconds")
    public void verify_response_time(int minResponseTimeSeconds) {
        // Measure the response time in milliseconds
        long responseTimeMillis = response.getTime();

        // Convert milliseconds to seconds
        double actualResponseTimeSeconds = responseTimeMillis / 1000.0;

        // Verify that the actual response time is not less than the specified minimum time
        assertTrue(actualResponseTimeSeconds >= minResponseTimeSeconds);
    }
}
