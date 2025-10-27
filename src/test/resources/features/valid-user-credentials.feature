# Feature: Valid User Credentials Authorization
# Purpose: To verify that the /Account/v1/Authorized API endpoint successfully authorizes valid user credentials.

Feature: Valid user credentials authorization
  As an API consumer
  I want to verify that valid user credentials are authorized successfully
  So that only valid users can access protected resources

  Background:
    Given the API base URI is set
    And the Content-Type header is set to "application/json"

  @positive @authorization
  Scenario Outline: Authorize valid user credentials
    Given valid user credentials with username "<username>" and password "<password>"
    When I send a POST request to "/Account/v1/Authorized" endpoint
    Then the response status code should be 200
    And the response body should be empty or contain a success message

    Examples:
      | username      | password      |
      | validUser1    | ValidPass123! |
      | validUser2    | ValidPass456! |
