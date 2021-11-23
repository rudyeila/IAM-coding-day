package com.iamcd.team4.backend.logic.operations;

import com.iamcd.team4.backend.infrastructure.communication.ForgerockAMCommunicator;
import com.iamcd.team4.backend.logic.InsuranceProvider;
import com.iamcd.team4.backend.logic.model.User;
import com.iamcd.team4.backend.logic.model.insurance.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOperations {

    private ForgerockAMCommunicator forgerockAMCommunicator;
    private InsuranceProvider insuranceProvider;

    @Autowired
    public UserOperations(ForgerockAMCommunicator forgerockAMCommunicator, InsuranceProvider insuranceProvider) {
        this.forgerockAMCommunicator = forgerockAMCommunicator;
        this.insuranceProvider = insuranceProvider;
    }


    public User getUser(String token) {
        User user = forgerockAMCommunicator.getUserInfo(token);
        List<Insurance> insuranceOffers = insuranceProvider.getOffers(user.getHobbies());
        user.setInsuranceOffers(insuranceOffers);
        return user;
    }

}
