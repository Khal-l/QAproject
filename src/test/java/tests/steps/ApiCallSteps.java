package tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class ApiCallSteps {

    private Response response;

    @Given("the API is available")
    public void the_api_is_available1() {
        String apiUrl = "https://open.er-api.com/v6/latest/USD"; // Replace with your API endpoint
        ApiHelper.verifyApiAvailability(apiUrl);
    }

    @When("the user makes a GET request to retrieve the price")
    public void user_makes_get_request1() {
        // Code to make GET request to API
        RequestSpecification request = given();
        response = request.get("https://open.er-api.com/v6/latest/USD");
    }

    @Then("the response status code should be 200")
    public void verify_status_code1(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }


    @Then("the response body should contain a valid price")
    public void verify_valid_price() {
        // Code to verify response body contains valid price

        // Check if response is not null
        if (response != null) {
            // Retrieve response body as a String
            String responseBody = response.getBody().asString();

// Parse the response body and extract the price
            JsonPath jsonPath = new JsonPath(responseBody);
            double price = jsonPath.getDouble("rates.USD");


        } else {
            // Handle case when response is null (e.g., API call failed)
            // You can throw an exception or log an error message
            throw new RuntimeException("API response is null. Check if API call was successful.");
        }
    }
}
