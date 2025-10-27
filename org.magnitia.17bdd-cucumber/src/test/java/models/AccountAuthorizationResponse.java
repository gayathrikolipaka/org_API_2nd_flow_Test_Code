package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for /Account/v1/Authorized response payload
 * As per the test case, a successful authorization returns 200 OK with an empty body or a success message.
 * This class will handle both scenarios.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountAuthorizationResponse {
    // If the response is empty, this class remains empty.
    // If a success message is returned, add the field below.

    // Example placeholder for a possible success message:
    // @JsonProperty("message")
    // private String message; // TODO: Replace with actual field from payload if needed

    // Empty constructor
    public AccountAuthorizationResponse() {
    }

    // If a message field is added, include getter/setter and constructor accordingly.
}
