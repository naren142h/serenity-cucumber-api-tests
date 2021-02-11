package com.example.stepdefs;

import com.example.SwaggerApiEndpoints;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllClientsSteps extends BaseTest{

    @Given("The request to get all Clients options")
    public void theRequestToGetAllClientsOptions () {
        SerenityRest.given()
                .baseUri(BASE_URI);
    }

    @When("The request is made to the endpoint")
    public void theRequestIsMadeToTheEndpoint() {
        SerenityRest.when().get(SwaggerApiEndpoints.GET_ALL_CLIENTS.getUrl());
    }

    @Then("The result with all Clients options is returned")
    public void theResultWithAllClientsOptionsIsReturned() {
        restAssuredThat(response -> response
                .statusCode(HttpStatus.SC_OK)
                .body("", is(notNullValue())));
    }
}
