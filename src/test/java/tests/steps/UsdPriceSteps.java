package tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UsdPriceSteps {

    private Response response;

    @Given("the API is available")
    public void the_api_is_available5() {
        String apiUrl = "https://open.er-api.com/v6/latest/USD"; // Replace with your API endpoint
        ApiHelper.verifyApiAvailability(apiUrl);
    }

    @When("the user makes a GET request to retrieve the price")
    public void user_makes_get_request5() {
        // Code to make GET request to API
        RequestSpecification request = given();
        response = request.get("https://open.er-api.com/v6/latest/USD");
    }

    @Then("the response status code should be 200")
    public void verify_status_code5() {
        // Code to verify response status code
        int expectedStatusCode = 200; // Define the expected status code
        int actualStatusCode = response.getStatusCode(); // Extract the actual status code from the response object
        assertEquals(expectedStatusCode, actualStatusCode); // Compare the expected and actual status codes
    }

    @Then("the USD price should be within range {double} - {double}")
    public void verify_usd_price_range(double minPrice, double maxPrice) {
        // Extract the USD price from the response body
        JsonPath jsonPath = response.jsonPath();
        double actualUsdPrice = jsonPath.getDouble("rates.USD");

        // Verify that the actual USD price is within the specified range
        assertTrue(actualUsdPrice >= minPrice && actualUsdPrice <= maxPrice);
    }
}
