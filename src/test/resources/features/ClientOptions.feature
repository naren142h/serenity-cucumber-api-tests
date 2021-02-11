Feature: Client Options

  Scenario: Lookup all available client options
    Given The request to get all client options
    When The request is made to the endpoint
    Then The result with all client options is returned