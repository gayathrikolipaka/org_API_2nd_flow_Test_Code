package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import java.util.Map;

public class InvalidJsonFormatSteps {

    private RequestSpecification request;
    private Response response;
    private String baseUri = System.getProperty("api.baseUri", "http://localhost:8080"); // Use config or env if available
    private String contentType = "application/json";

    @Given("the base URI is set for the API")
    public void the_base_uri_is_set_for_the_api() {
        RestAssured.baseURI = baseUri;
        request = RestAssured.given();
    }

    @And("the Content-Type header is set to {string}")
    public void the_content_type_header_is_set_to(String contentType) {
        request.header("Content-Type", contentType);
    }

    @When("I send a POST request to {string} with invalid JSON body:")
    public void i_send_a_post_request_to_with_invalid_json_body(String endpoint, String docString) {
        // Use the docString as the invalid JSON body
        response = request
                .body(docString)
                .when()
                .post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode.intValue(), response.getStatusCode());
    }

    @And("the response body should contain an error message indicating invalid JSON format")
    public void the_response_body_should_contain_an_error_message_indicating_invalid_json_format() {
        String responseBody = response.getBody().asString();
        // Check for common error message patterns for invalid JSON
        boolean containsInvalidJsonMsg = responseBody.toLowerCase().contains("invalid json")
                || responseBody.toLowerCase().contains("malformed")
                || responseBody.toLowerCase().contains("parse error")
                || responseBody.toLowerCase().contains("unexpected character")
                || responseBody.toLowerCase().contains("bad request");
        Assert.assertTrue("Response body does not indicate invalid JSON format. Actual: " + responseBody, containsInvalidJsonMsg);
    }
}
