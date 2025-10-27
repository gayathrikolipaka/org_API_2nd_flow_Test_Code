package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;
import org.json.JSONObject;

public class ValidUserCredentialsAuthorizationSteps {
    private static final String BASE_URI = System.getProperty("api.baseUri", "https://bookstore.toolsqa.com");
    private RequestSpecification request;
    private Response response;
    private String username;
    private String password;

    @Given("the API base URI is set")
    public void the_api_base_uri_is_set() {
        RestAssured.baseURI = BASE_URI;
        request = RestAssured.given();
    }

    @And("the Content-Type header is set to {string}")
    public void the_content_type_header_is_set_to(String contentType) {
        request.header("Content-Type", contentType);
    }

    @Given("valid user credentials with username {string} and password {string}")
    public void valid_user_credentials_with_username_and_password(String username, String password) {
        this.username = username;
        this.password = password;
        JSONObject payload = new JSONObject();
        payload.put("userName", username);
        payload.put("password", password);
        request.body(payload.toString());
    }

    @When("I send a POST request to \"/Account/v1/Authorized\" endpoint")
    public void i_send_a_post_request_to_account_v1_authorized_endpoint() {
        response = request.post("/Account/v1/Authorized");
    }

    @Then("the response status code should be 200")
    public void the_response_status_code_should_be_200() {
        assertEquals(200, response.getStatusCode());
    }

    @And("the response body should be empty or contain a success message")
    public void the_response_body_should_be_empty_or_contain_a_success_message() {
        String body = response.getBody().asString();
        // Accept empty or 'true' (per API doc), or a success message
        assertTrue(body == null || body.trim().isEmpty() || body.trim().equalsIgnoreCase("true") || body.toLowerCase().contains("success"));
    }
}
