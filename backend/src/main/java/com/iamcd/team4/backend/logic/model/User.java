package com.iamcd.team4.backend.logic.model;

import java.beans.ConstructorProperties;
import java.util.List;

import com.iamcd.team4.backend.logic.model.insurance.Insurance;
import lombok.Data;
import lombok.Getter;

/*
{
    "localityName": "Heidelberg",
    "stateOrProvinceName": "Baden-Wuerttemberg",
    "postalCode": "69115",
    "country": "Germany",
    "given_name": "Otto",
    "family_name": "Hartmann",
    "gender": "male",
    "hobbies": [
        "dancing",
        "climbing",
        "poker"
    ],
    "birthday": "1996-05-12",
    "job": "accountant",
    "email": "otto.hartmann@privat.com",
    "sub": "otto.hartmann@privat.com"
}
 */

@Data
public class User {

    private String sub;
    private String email;
    private String given_name;
    private String family_name;
    private String job;
    private String birthday;
    private String gender;
    private String localityName;
    private String postalCode;
    private String stateOrProvinceName;
    private String country;
    private List<String> hobbies;
    private List<Insurance> insuranceOffers;



    @ConstructorProperties({"sub", "email", "given_name", "family_name", "job", "birthday", "gender", "localityName",
            "postalCode", "stateOrProvinceName", "country", "hobbies", "insuranceOffers"})
    public User(String sub, String email, String given_name, String family_name, String job, String birthday,
                String gender, String localityName, String postalCode, String stateOrProvinceName,
                String country, List<String> hobbies,
                List<Insurance> insuranceOffers) {
        this.sub = sub;
        this.email = email;
        this.given_name = given_name;
        this.family_name = family_name;
        this.job = job;
        this.birthday = birthday;
        this.gender = gender;
        this.localityName = localityName;
        this.postalCode = postalCode;
        this.stateOrProvinceName = stateOrProvinceName;
        this.country = country;
        this.hobbies = hobbies;
        this.insuranceOffers = insuranceOffers;
    }

}
