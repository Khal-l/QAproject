# Project Title:TESTING AN API FOR EXCHANGING RATES
### THIS IS THE PROJECT REQUIREMENTS:
#### SDET Assessment
Given the API: https://open.er-api.com/v6/latest/USD

Returns the USD rates against multiple currency.
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
  - Enter your project's "GroupId" (e.g., cloud.digitalchain) and "ArtifactId" (e.g., currency-api-test).
  - Define the project name and location.
  - Click "Finish" to create the project.

4. **POM Configuration**:
   This Maven `pom.xml` file is configured with essential dependencies and plugins to facilitate the testing of your API. Notably, the `<artifactId>` tag specifies the unique identifier for your project, which is crucial for referencing and managing your project within the Maven ecosystem.

- **Artifact ID**: `APIcurrency_QA`

Using a descriptive and meaningful `artifactId` like `APIcurrency_QA` ensures clarity and coherence within your project and its associated artifacts. It serves as a recognizable label for your project, making it easier to identify and manage across various contexts, such as Maven builds, dependency management, and project documentation.

```xml
<artifactId>APIcurrency_QA</artifactId>
```

**Project Identifiers**

- **Group ID**: `cloud.digitalchain`
- **Artifact ID**: `currency-api-test`
- **Version**: `1.0-SNAPSHOT`
- **Packaging**: `jar`

**Properties**

- Java source and target compatibility are set to version 17.
- UTF-8 encoding is specified for project building.
- Versions for Serenity, Cucumber, RestAssured, JUnit, and Maven plugins are managed via properties for easy updates.

**Dependencies**

## Cucumber
- **cucumber-junit:** Allows running Cucumber tests with JUnit.
- **serenity-cucumber:** Integration between Cucumber and Serenity for BDD testing.

## JUnit Jupiter
- **junit-jupiter-api:** Provides the API for writing tests with JUnit 5.

## Serenity BDD
- **serenity-core:** Core library for the Serenity BDD framework.
- **serenity-junit:** Integration between JUnit and Serenity.
- **serenity-screenplay:** Library for implementing the Screenplay pattern in Serenity tests.
- **serenity-screenplay-webdriver:** Screenplay support for WebDriver interactions.
- **serenity-screenplay-rest:** Screenplay support for RESTful API testing.
- **serenity-rest-assured:** Integration between Rest Assured and Serenity.

## Other
- **json:** JSON processing library.
- **rest-assured:** Testing library for REST APIs.
- **json-schema-validator:** JSON schema validation library for Rest Assured.

**Build Configuration**

- The `maven-surefire-plugin` is configured to skip the default test phase.
- The `maven-failsafe-plugin` is set up to run integration tests, configured for parallel execution with unlimited threads.
- The `maven-compiler-plugin` sets the Java version for source and target compatibility.
- The `serenity-maven-plugin` is set up for post-integration test phase to generate aggregated Serenity reports.

This `pom.xml` establishes a framework for running robust, automated API tests, ensuring that the application's REST endpoints perform as expected across different scenarios and environments.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>APIcurrency_QA</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <dependencies>
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>7.15.0</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/net.serenity-bdd/serenity-cucumber -->
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-cucumber</artifactId>
            <version>4.1.4</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.10.2</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/net.serenity-bdd/serenity-core -->
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-core</artifactId>
            <version>4.1.3</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/net.serenity-bdd/serenity-junit -->
        <!-- https://mvnrepository.com/artifact/net.serenity-bdd/serenity-junit -->
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-junit</artifactId>
            <version>4.1.3</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/net.serenity-bdd/serenity-screenplay -->
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-screenplay</artifactId>
            <version>4.1.3</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/net.serenity-bdd/serenity-screenplay-webdriver -->
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-screenplay-webdriver</artifactId>
            <version>4.1.3</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/net.serenity-bdd/serenity-screenplay-rest -->
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-screenplay-rest</artifactId>
            <version>4.1.4</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/net.serenity-bdd/serenity-rest-assured -->
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-rest-assured</artifactId>
            <version>4.1.3</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.json/json -->
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20240303</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.4.0</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>json-schema-validator</artifactId>
            <version>5.4.0</version>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-failsafe-plugin</artifactId>
                <version>3.2.5</version>
                <configuration>
                    <includes>
                        <include>**/*.java</include>
                    </includes>
                </configuration>
                <executions>
                    <execution>
                        <id>integration-tests</id>
                        <goals>
                            <goal>integration-test</goal>
                            <goal>verify</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.12.1</version>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>net.serenity-bdd.maven.plugins</groupId>
                <artifactId>serenity-maven-plugin</artifactId>
                <version>4.1.3</version>
                <dependencies>
                    <dependency>
                        <groupId>net.serenity-bdd</groupId>
                        <artifactId>serenity-core</artifactId>
                        <version>4.1.3</version>
                    </dependency>
                </dependencies>
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
- For Maven: Open the pom.xml file and add dependencies for Cucumber, JUnit, RestAssured, and Serenity. Here's an example of what the dependencies might look like:
- After adding the dependencies, IntelliJ should automatically start downloading them. If it doesn’t, you can trigger a reload of the project.


5. **Enable Annotation Processing (if necessary):**
- Go to “File” > “Settings” > “Build, Execution, Deployment” > “Compiler” > “Annotation Processors.”
- Check “Enable annotation processing.”
- Click “Apply” and “OK.”

6. **Create Base Project Structure:**
- Organize your project with directories for your features, step definitions, and utility classes within the src/test/java and src/test/resources folders as an example:
# PROJECT STRUCTURE:
```bash

├── src
│   ├── main
│   │   
│   └── test
│       └── java
│       │    └── tests
│       │            └── steps
│       │            │    │── ApiEndPoints.java 
│       │            │    │── checkStatusCodeSteps.java
│       │            │    │── currencyPairsSteps.java 
│       │            │    │── RespSchemaSteps.java      
│       │            │    │── RespTimeSteps.java
│       │            │    │── USDtoAEDSteps.java 
│       │            │    └── ValidRespSteps.java 
│       │            └── cucumberRunnerSteps.java 
│       └── resources
│                   └── features
│                   │    │── checkStatusCode.feature 
│                   │    │── currencyPairs.feature 
│                   │    │── RespSchema.feature     
│                   │    │── RespTime.feature
│                   │    │── USDtoAED.feature 
│                   │    └── ValidResp.feature
│                   └── schemas
│                         └── schema.json             
├── pom.xml  
└── README.md                              
```

# Step 2: Project Structure for BDD Testing with Serenity

Proper project structuring is crucial for maintaining a clear and manageable codebase, especially when integrating Serenity for BDD testing. Follow these guidelines to structure your Maven or Gradle project in IntelliJ IDEA.

## Main Source Directory

- **Location**: `src/main/java`
- **Purpose**: Contains the main source code of your application.
- **Note**: Even though the focus is on testing, it's good practice to maintain this standard structure.

## Test Source Directory

- **Location**: `src/test/java`
- **Purpose**: Houses all your test code, including BDD step definitions and supporting Java classes.
- **Structure**:
  - Store your BDD step definitions and any supporting Java classes here.
  - Organize step definitions and helper classes into appropriate packages, for example, `cloud.digitalchain.currencyapitest.steps` and `cloud.digitalchain.currencyapitest.utils`.

## Resource Directories

### Main Resources

- **Location**: `src/main/resources`
- **Purpose**: Stores configuration files and other necessary resources for the application.
- **Note**: This directory might not be heavily used in the context of this project.

### Test Resources

- **Location**: `src/test/resources`
- **Purpose**: Crucial for storing Cucumber feature files.
- **Structure**:
  - Create a `features` directory to contain your `.feature` files.
  - These feature files should define your BDD scenarios using Gherkin syntax.

## Configuring Cucumber with Serenity

Set up a Serenity-enabled Cucumber runner class to benefit from enhanced reporting and test management capabilities:

- **Example `TestRunner` class with Serenity**:
 
```java
  package tests;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
features = "src/test/resources/features",
glue = {"tests.steps"}, // Ensure this points to the correct package
plugin = {"pretty", "html:target/cucumber-reports"}
)
public class cucumberRunnerSteps {

}
 ```
# Step 3: Writing BDD Features and Scenarios with Serenity

For Step 3, we'll focus on writing BDD features and scenarios using Cucumber and Serenity in the IntelliJ IDEA environment.
For each test, We'll create a feature file that describes the behavior of the API, with a particular focus on fetching the USD to AED rate and validating various response aspects.

## 1. Create a Feature File

- **Location**: Place your feature file in the `src/test/resources/features` directory.
- **File Creation**: Create a new file named for example `ValidResp.feature`.
- **Content**: Feature files should have the `.feature` extension and contain text written in Gherkin syntax, which can be understood in plain English (or your chosen language).

## 2. Define the Feature and Scenarios

- **Feature Definition**: Start by defining the feature and outlining its purpose. Then, detail the scenarios using Given, When, Then, And steps.

### Example Content for `ValidResp.feature`:

```gherkin
Feature: Successful API Call

  Scenario: Verify API call is successful and returns valid price
    Given the API is accessible
    When the user makes a request to the API
    Then the response status code should be 200
    And the response body should contain a valid price
```
## 3. Understanding the Gherkin Syntax

-  Given: Sets up the context for the scenario.
-  When: Describes the action that triggers the scenario.
-  Then: Specifies the expected outcome or result.
-  And: Used for adding additional steps while maintaining readability.

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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class ValidRespSteps {
  @Given("the API is accessible")
  public void theAPIIsAccessible() {
  }

  @When("the user makes a request to the API")
  public void theUserMakesARequestToTheAPI() {

  }

  @Then("the response status code should be {int}")
  public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
    given()
            .get(ApiEndPoints.USD_LATEST_ENDPOINT)
            .then()
            .statusCode(expectedStatusCode);
  }

  @Then("the response body should contain a valid price")
  public void theResponseBodyShouldContainAValidPrice() {
    given()
            .get(ApiEndPoints.USD_LATEST_ENDPOINT)
            .then()
            .body("rates.USD", equalTo(1));
  }
}
```

1. **Validating the API Call and Response**

- Ensure the API call is successful and returns a valid response. The status code check is already implemented in the step definitions. Additionally, verify that the response body is not empty.

2. **Checking the Response Status**

- Implement steps to check if the response status indicates success or other statuses like FAILURE.

3. **Validating the USD to AED Rate**

- Include a method in the step definitions to verify the USD to AED rate is within the specified range (3.6 - 3.7), ensuring the rate is present and within the expected range.

4. **Response Time Validation**

- Add a step definition to validate that the API response time is less than the specified threshold (e.g., 3 seconds).

5. **Timestamp Verification**

- Verify that the API response includes a timestamp, checking for its presence and possibly validating its format.

6. **Currency Pairs Count Validation**

- Confirm that the API returns data for 162 currency pairs by asserting the size of the rates object in the JSON response.

7. **JSON Schema Validation**

- Utilize RestAssured's schema validation feature to ensure the API response matches the expected JSON schema. Generate a JSON schema from the API response and use it in a step definition.

## 3. Connect Steps to Feature File

The Java methods are connected to the steps in your feature file via the annotations. Cucumber, integrated with Serenity, will execute the Java code for each step during the test run.

## 4. Running Your Tests

After implementing the step definitions, run the TestRunner class to execute your feature file scenarios. Serenity enhances the output, showing which steps passed or failed and providing detailed reports.

**maven command**
-  Let's run the code: maven clean install
-  Responses show all tests successful

