package tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CurrencyPairsSteps {
    private Response response;

    @Given("the API is available")
    public void the_api_is_available3() {
        String apiUrl = "https://open.er-api.com/v6/latest/USD"; // Replace with your API endpoint
        ApiHelper.verifyApiAvailability(apiUrl);
    }

    @When("the user makes a GET request to retrieve the price")
    public void user_makes_get_request3() {
        // Code to make GET request to API
        RequestSpecification request = given();
        response = request.get("https://open.er-api.com/v6/latest/USD");
    }

    @Then("the response status code should be 200")
    public void verify_status_code3() {
        // Code to verify response status code
        int expectedStatusCode = 200; // Define the expected status code
        int actualStatusCode = response.getStatusCode(); // Extract the actual status code from the response object
        assertEquals(expectedStatusCode, actualStatusCode); // Compare the expected and actual status codes
    }

    @Then("the number of currency pairs returned should be {int}")
    public void verify_currency_pairs_count(int expectedCount) {
        // Parse the response body and extract the rates object
        JsonPath jsonPath = response.jsonPath();
        Map<String, Double> rates = jsonPath.getMap("rates", String.class, Double.class);

        // Count the number of currency pairs
        int actualCount = rates.size();

        // Compare the expected and actual counts
        assertEquals(expectedCount, actualCount);
    }
}
