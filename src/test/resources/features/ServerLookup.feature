Feature: Lookup a particular framework detail in servers

  Scenario: True is returned for a request with valid server framework
    Given The request with valid framework
    When The request is made with GET method to server framework details endpoint
    Then The response with success is returned

  Scenario: Bad request is returned for a request with invalid server framework
    Given The request with invalid framework
    When The request is made with GET method to server framework details endpoint
    Then The response with bad request is returned