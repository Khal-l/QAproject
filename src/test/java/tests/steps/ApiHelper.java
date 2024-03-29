package tests.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;

public class ApiHelper {

    public static void verifyApiAvailability(String apiUrl) {
        Response response = RestAssured.get(apiUrl);
        int statusCode = response.getStatusCode();
        assertEquals("API is not available", 200, statusCode);
    }
}
