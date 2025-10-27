package models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO for /Account/v1/Authorized request payload
 * Maps to the API request for user authorization with username and password
 */
public class AccountAuthorizationRequest {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    public AccountAuthorizationRequest() {
    }

    public AccountAuthorizationRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
