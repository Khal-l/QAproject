# Project Title: TESTING AN API FOR EXCHANGING RATES

### PROJECT REQUIREMENTS:
#### SDET Assessment

Given the API: [https://open.er-api.com/v6/latest/USD](https://open.er-api.com/v6/latest/USD)

Returns the USD rates against multiple currencies.

#### Task

- Create a test framework using Java/JVM language framework.
    - BDD approach would be an added advantage.
- Write necessary tests to cover the acceptance criteria below.
- Make sure code is modular and easily understood.
- Structure the code properly so that making changes becomes easier.
- Upload the solution in bitbucket/GitHub and share the link of the repo
- Include a README.md file.

#### Description

Key features of this test framework include:

- **API Response Validation**: Ensures successful API calls and checks for valid response structures and data, employing RestAssured for HTTP interactions.
- **Response Status Verification**: Incorporates checks for various API response statuses to ensure the API's robust error handling and success message conveyance.
- **Rate Validation**: Specifically tests the USD to AED rate, ensuring the values fall within the expected range, thus verifying the API's currency conversion accuracy.
- **Performance Checks**: Includes validations for the API's response time, ensuring the API's performance is within acceptable thresholds.
- **Data Integrity**: Validates the presence of essential response elements like timestamps and the correct count of currency pairs, ensuring comprehensive data delivery.
- **Schema Compliance**: Utilizes JSON schema validation to confirm the API's response adheres to the defined structure, ensuring consistency and reliability in the data provided.
- **Extensibility**: Designed with modularity in mind, allowing easy expansion to include more currencies or additional API endpoints.
- **Enhanced Reporting**: Integrates Serenity for enriched reporting and test documentation, providing clear insights into test executions and outcomes, facilitating continuous integration and deployment processes.

## Step 1: Setting Up the Project in IntelliJ IDEA

1. **Open IntelliJ IDEA**:
    - If you don't have IntelliJ IDEA installed, download and install it from the JetBrains website.
    - Launch IntelliJ IDEA.

2. **Create a New Project**:
    - On the IntelliJ IDEA welcome screen, select "New Project."
    - In the New Project window, choose "Maven" or "Gradle" on the left panel depending on your preference.
    - Ensure the "Java" option is selected and the JDK is set (download a JDK if necessary).
    - Click "Next" to proceed.

3. **Configure Project Details**:
    - Enter your project's "GroupId" (e.g., `com.ApiTest`) and "ArtifactId" (e.g., `SDET`).
    - Define the project name and location.
    - Click "Finish" to create the project.

4. **POM Configuration**:
   This Maven `pom.xml` file is configured with essential dependencies and plugins to facilitate the testing of your API. Notably, the `<artifactId>` tag specifies the unique identifier for your project, which is crucial for referencing and managing your project within the Maven ecosystem.

    - **Artifact ID**: `SDET`

   Using a descriptive and meaningful `artifactId` like `SDET` ensures clarity and coherence within your project and its associated artifacts. It serves as a recognizable label for your project, making it easier to identify and manage across various contexts, such as Maven builds, dependency management, and project documentation.

## Step 2: Project Structure for BDD Testing with Serenity

Proper project structuring is crucial for maintaining a clear and manageable codebase, especially when integrating Serenity for BDD testing. Follow these guidelines to structure your Maven or Gradle project in IntelliJ IDEA.

### Main Source Directory

- **Location**: `src/main/java`
- **Purpose**: Contains the main source code of your application.
- **Note**: Even though the focus is on testing, it's good practice to maintain this standard structure.

### Test Source Directory

- **Location**: `src/test/java`
- **Purpose**: Houses all your test code, including BDD step definitions and supporting Java classes.
- **Structure**:
    - Store your BDD step definitions and any supporting Java classes here.
    - Organize step definitions and helper classes into appropriate packages, for example, `tests.steps`.
### Resource Directories

#### Main Resources

- **Location**: `src/main/resources`
- **Purpose**: Stores configuration files and other necessary resources for the application.
- **Note**: This directory might not be heavily used in the context of this project.

#### Test Resources

- **Location**: `src/test/resources`
- **Purpose**: Crucial for storing Cucumber feature files.
- **Structure**:
    - Create a `features` directory to contain your `.feature` files.
    - These feature files should define your BDD scenarios using Gherkin syntax.
### This project file topology is 

```bash
    ├── .idea
    ├── src
    │   ├── main
    │   │   └── java/org/example
    │   │       └── Main.java
    │   ├── test
    │   │   ├── java/tests/steps
    │   │   │   ├── ApiCallSteps.java
    │   │   │   ├── ApiHelper.java
    │   │   │   ├── ApiStatusSteps.java
    │   │   │   ├── CurrencyPairsSteps.java
    │   │   │   ├── JsonSchemaSteps.java
    │   │   │   ├── ResponseTimeSteps.java
    │   │   │   └── UsdPriceSteps.java
    │   │   ├── resources
    │   │   │   ├── feature
    │   │   │   │   ├── api_call.feature
    │   │   │   │   ├── api_status.feature
    │   │   │   │   ├── currency_pairs.feature
    │   │   │   │   ├── json_schema.feature
    │   │   │   │   ├── response_time.feature
    │   │   │   │   └── usd_price.feature
    │   │   │   └── schemas
    │   │   │       └── usd_rate_schema.json
    │   │   └── java
    │   │       └── TestRunner.java
    ├── .gitignore
    ├── pom.xml
    └── README.md

```
## Step 3: Writing BDD Features and Scenarios with Serenity

For Step 3, we'll focus on writing BDD features and scenarios using Cucumber and Serenity in the IntelliJ IDEA environment.
For each test, We'll create a feature file that describes the behavior of the API, with a particular focus on fetching the USD to AED rate and validating various response aspects.

### 1. Create a Feature File

- **Location**: Place your feature file in the `src/test/resources/features` directory.
- **File Creation**: Create a new file named for example `api_call.feature`.
- **Content**: Feature files should have the `.feature` extension and contain text written in Gherkin syntax, which can be understood in plain English (or your chosen language).

### 2. Define the Feature and Scenarios

- **Feature Definition**: Start by defining the feature and outlining its purpose. Then, detail the scenarios using Given, When, Then, And steps.

#### Example Content for `api_call.feature`:
Feature: Verify API call returns valid price

Scenario: Verify successful API call and valid price returned
Given the API is available
When the user makes a GET request to retrieve the price
Then the response status code should be 200
And the response body should contain a valid price

## 3. Understanding the Gherkin Syntax

- Given: Sets up the context for the scenario.
- When: Describes the action that triggers the scenario.
- Then: Specifies the expected outcome or result.
- And: Used for adding additional steps while maintaining readability.

## 4. Next Steps

After defining the features and scenarios, the next step involves implementing the step definitions in Java, integrating Serenity to enhance the testing process. These definitions will contain the actual code to interact with the API and assert the expected outcomes, leveraging Serenity's capabilities for richer test context and reporting.

# Step 4: Implementing Step Definitions in Java with Serenity

In Step 4, we'll implement the step definitions in Java for the scenarios defined in the `ValidResp.feature` file, integrating Serenity to enhance the testing process.

## 1. Create Step Definitions Java File

- **Location**: In the `src/test/java/tests/steps` directory, create a new Java class named `ValidResp`.

## 2. Implement Step Definitions

- Implement methods for each step in your feature file within `ValidRespSteps.java`.
- These methods should be annotated with `@Given`, `@When`, `@Then`, and `@And` from Cucumber to connect the Java code to the Gherkin steps.

### Step Definitions Template

```java
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
    

```
## 3. Validating the API Call and Response

To ensure the API call is successful and returns the expected response, we need to validate both the response status code and the response body.

### Implementing Validation in Step Definitions

In the step definitions, we'll define steps to validate the API call and response.

- **Verifying Response Status Code**: Check if the response status code matches the expected value.
- **Validating Response Body**: Ensure that the response body contains the expected data.

These validations ensure that the API call was successful and that the response contains the expected data.

## 4. Checking the Response Status

It's essential to verify that the response status code indicates success or other specific conditions. Let's enhance our step definitions to handle various response statuses.

### Implementing Response Status Validation

Extend the step definitions to handle different response statuses:

- **Verifying Response Status Code**: Method to verify that the actual response status code matches the expected status code provided in the Gherkin scenario.

## 5. Validating the USD to AED Rate

One of the critical aspects of our API testing is to validate the accuracy of the currency conversion rates, such as the USD to AED rate. We'll implement steps to ensure this rate falls within the expected range.

### Implementing Rate Validation

Add a method to verify that the USD to AED rate falls within the expected range.

## 6. Response Time Validation

Response time validation ensures that the API responds within an acceptable timeframe. Let's add a step definition to validate the API's response time.

### Implementing Response Time Validation

Create a method to check if the API responds within a specified duration.

## 7. Timestamp Verification

To ensure data freshness and integrity, we'll validate the presence and format of timestamps in the API response.

### Implementing Timestamp Verification

Add a step definition to validate the timestamp format and presence in the API response.

## 8. Currency Pairs Count Validation

Our API should provide data for a specific number of currency pairs. Let's validate the count of currency pairs in the response.

### Implementing Currency Pairs Count Validation

Create a step definition to ensure the API response contains data for the expected number of currency pairs.

## 9. JSON Schema Validation

JSON schema validation ensures that the API response structure complies with a predefined schema. Let's implement this validation.

### Implementing JSON Schema Validation

Create a step definition to validate the API response against a predefined JSON schema.

These step definitions cover comprehensive validation aspects, ensuring the correctness, reliability, and performance of the API under test.

## 11. Running Your Tests

After implementing the step definitions, run the tests to execute your feature file scenarios. Ensure that all tests pass, confirming the robustness and reliability of your API testing framework.

## 12. pom.xml
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.ApiTest</groupId>
  <artifactId>SDET</artifactId>
  <version>1.0-SNAPSHOT</version>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <serenity.version>4.0.18</serenity.version>
    <rest.assured.version>5.3.2</rest.assured.version>
    <junit.version>4.13.2</junit.version>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
    <maven.surefire.plugin.version>3.0.0-M5</maven.surefire.plugin.version>
    <maven.failsafe.plugin.version>3.0.0-M5</maven.failsafe.plugin.version>
    <serenity.maven.plugin.version>4.1.0</serenity.maven.plugin.version>
  </properties>

  <dependencies>
    <dependency>
      <groupId>net.serenity-bdd</groupId>
      <artifactId>serenity-core</artifactId>
      <version>${serenity.version}</version>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>net.serenity-bdd</groupId>
      <artifactId>serenity-cucumber</artifactId>
      <version>${serenity.version}</version>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>net.serenity-bdd</groupId>
      <artifactId>serenity-rest-assured</artifactId>
      <version>${serenity.version}</version>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>io.rest-assured</groupId>
      <artifactId>rest-assured</artifactId>
      <version>${rest.assured.version}</version>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>io.rest-assured</groupId>
      <artifactId>json-schema-validator</artifactId>
      <version>${rest.assured.version}</version>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>${junit.version}</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>${maven.surefire.plugin.version}</version>
        <configuration>
          <includes>
            <include>**/*Test.java</include>
          </includes>
          <parallel>methods</parallel>
          <useUnlimitedThreads>true</useUnlimitedThreads>
        </configuration>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-failsafe-plugin</artifactId>
        <version>${maven.failsafe.plugin.version}</version>
        <configuration>
          <includes>
            <include>**/*Test.java</include>
          </includes>
          <parallel>methods</parallel>
          <useUnlimitedThreads>true</useUnlimitedThreads>
        </configuration>
        <executions>
          <execution>
            <goals>
              <goal>integration-test</goal>
              <goal>verify</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <groupId>net.serenity-bdd.maven.plugins</groupId>
        <artifactId>serenity-maven-plugin</artifactId>
        <version>${serenity.maven.plugin.version}</version>
        <dependencies>
          <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-single-page-report</artifactId>
            <version>${serenity.version}</version>
          </dependency>
        </dependencies>
        <configuration>
          <tags>${tags}</tags>
          <reports>single-page-html</reports>
        </configuration>
        <executions>
          <execution>
            <id>serenity-reports</id>
            <phase>post-integration-test</phase>
            <goals>
              <goal>aggregate</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
</project>
```
