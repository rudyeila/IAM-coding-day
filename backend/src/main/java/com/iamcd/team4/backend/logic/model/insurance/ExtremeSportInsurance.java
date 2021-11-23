package com.iamcd.team4.backend.logic.model.insurance;

import lombok.Data;

@Data
public class ExtremeSportInsurance extends Insurance {

    public ExtremeSportInsurance(double price) {
        super(price);
        this.name = "Extreme Sport Insurance Package";
        this.description = "An insurance policy for extreme sports";
        this.pricePer = "Year";
    }

}
