package com.iamcd.team4.backend.logic.model.insurance;

public class BikeInsurance extends Insurance {

    public BikeInsurance(double price) {
        super(price);
        this.name = "Bike Insurace";
        this.description = "Insurance policy that covers bike damage upto $200";
        this.pricePer = "Day";
    }
}
