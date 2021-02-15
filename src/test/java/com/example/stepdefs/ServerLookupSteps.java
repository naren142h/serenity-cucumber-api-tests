package com.example.stepdefs;

import com.example.SwaggerApiEndpoints;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ServerLookupSteps extends BaseTest {

    @Given("The request with valid framework")
    public void theRequestWithValidFramework() {
        validateframeworkRequest(getRandomValidClientServer());
    }

    @Given("the request with invalid framework")
    public void theRequestWithInvalidFramework() {
        validateframeworkRequest(getRandomInvalidClientServer());
    }

    @When("The request is made with GET method to server framework details endpoint")
    public void theRequestIsMadeWithGetMethodToServerFrameworkDetailsEndpoint() {
        SerenityRest.when().get(SwaggerApiEndpoints.GET_SERVER_OPTIONS.getUrl());
    }

    @Then("The response with success is returned")
    public void theResponseWithSuccessIsReturned() {
        restAssuredThat(response -> response
                .statusCode(HttpStatus.SC_OK)
                .body("opt", is(notNullValue())));
    }

    @Then("The response with bad request is returned")
    public void theResponseWithBadRequestIsReturned() {
        restAssuredThat(response ->  response
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("type", equalTo("error")));
    }

    private void validateframeworkRequest(String framework) {
        SerenityRest.given()
                .baseUri(BASE_URI)
                .pathParam("framework", framework);
    }
}
