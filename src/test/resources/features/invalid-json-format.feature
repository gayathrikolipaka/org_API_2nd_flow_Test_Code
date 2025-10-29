# Feature: Invalid JSON Format
# Category: Functional Testing | Sub-Category: Negative test case

Feature: Invalid JSON Format in User Creation API
  As an API consumer
  I want to ensure that the API returns an error when an invalid JSON format is sent in the request body
  So that the API is robust against malformed input

  Background:
    Given the base URI is set for the API
    And the Content-Type header is set to "application/json"

  Scenario Outline: Attempt to create a new user with invalid JSON format
    When I send a POST request to <endpoint> with invalid JSON body:
      """
      { "username": "testuser", "password": "pass123"   // missing closing brace
      """
    Then the response status code should be 400
    And the response body should contain an error message indicating invalid JSON format

    Examples:
      | endpoint         |
      | /users          |
