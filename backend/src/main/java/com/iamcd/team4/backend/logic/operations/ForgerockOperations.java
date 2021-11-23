package com.iamcd.team4.backend.logic.operations;

import com.iamcd.team4.backend.infrastructure.communication.ForgerockAMCommunicator;
import com.iamcd.team4.backend.logic.model.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForgerockOperations {
    private ForgerockAMCommunicator forgerockAMCommunicator;

    @Autowired
    public ForgerockOperations(ForgerockAMCommunicator forgerockAMCommunicator) {
        this.forgerockAMCommunicator = forgerockAMCommunicator;
    }

    public AccessToken getAccessToken(String authorizationCode) {
        return this.forgerockAMCommunicator.getAccessToken(authorizationCode);
    }



}
