package com.iamcd.team4.backend.logic.model;

import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class AccessToken {

    private String access_token;
    private String scope;
    private String token_type;
    private int expires_in;

    @ConstructorProperties({"access_token", "scope", "token_type", "expires_in"})
    public AccessToken(String access_token, String scope, String token_type, int expires_in) {
        this.access_token = access_token;
        this.scope = scope;
        this.token_type = token_type;
        this.expires_in = expires_in;
    }


}
