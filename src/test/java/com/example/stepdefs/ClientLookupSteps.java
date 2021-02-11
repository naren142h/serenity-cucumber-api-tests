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

public class ClientLookupSteps extends BaseTest{

    @Given("The request with valid language")
    public void theRequestWithValidLanguage() {
        validateLanguageRequest(getRandomValidClientServer());
    }

    @Given("the request with invalid language")
    public void theRequestWithInvalidLanguage() {
        validateLanguageRequest(getRandomInvalidClientServer());
    }

    @When("The request is made with GET method to client language details endpoint")
    public void theRequestIsMadeWithGetMethodToClientLanguageDetailsEndpoint() {
        SerenityRest.when().get(SwaggerApiEndpoints.GET_CLIENT_OPTIONS.getUrl());
    }

    @Then("The response with success is returned")
    public void theResponseWithSuccessIsReturned() {
        restAssuredThat(response -> response
                .statusCode(HttpStatus.SC_OK)
                .body("", is(notNullValue())));
    }

    @Then("The response with bad request is returned")
    public void theResponseWithBadRequestIsReturned() {
        restAssuredThat(response ->  response
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("type", equalTo("error")));
    }

    private void validateLanguageRequest(String language) {
        SerenityRest.given()
                .baseUri(BASE_URI)
                .pathParam("language", language);
    }
}
