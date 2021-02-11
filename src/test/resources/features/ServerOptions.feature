Feature: Server Options

  Scenario: Lookup all available server options
    Given The request to get all server options
    When The request is made to the endpoint
    Then The result with all server options is returned