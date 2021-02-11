Feature: Lookup a particular language detail in clients

  Scenario: True is returned for a request with valid client language
    Given The request with valid language
    When The request is made with GET method to client language details endpoint
    Then The response with success is returned

  Scenario: Bad request is returned for a request with invalid client language
    Given The request with invalid language
    When The request is made with GET method to client language details endpoint
    Then The response with bad request is returned