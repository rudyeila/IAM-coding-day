package com.iamcd.team4.backend.api.controller;

import com.iamcd.team4.backend.logic.model.AccessToken;
import com.iamcd.team4.backend.logic.model.User;
import com.iamcd.team4.backend.logic.operations.ForgerockOperations;
import com.iamcd.team4.backend.logic.operations.UserOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserController implements UserAPI {

    private UserOperations userOperations;
    private ForgerockOperations forgerockOperations;

    @Autowired
    public UserController(UserOperations userOperations, ForgerockOperations forgerockOperations) {
        this.userOperations = userOperations;
        this.forgerockOperations = forgerockOperations;
    }


    @Override
    public User getUser(@RequestParam String token) {
        return userOperations.getUser(token);
    }

    @Override
    public AccessToken getAccessToken(@RequestParam String authorizationCode) {
        return this.forgerockOperations.getAccessToken(authorizationCode);
    }

}
