package com.iamcd.team4.backend.api.controller;

import com.iamcd.team4.backend.logic.model.AccessToken;
import com.iamcd.team4.backend.logic.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping
public interface UserAPI {

    @GetMapping("/user")
    User getUser(@RequestParam String token);

    @GetMapping("/access_token")
    AccessToken getAccessToken(@RequestParam String authorizationCode);

}
