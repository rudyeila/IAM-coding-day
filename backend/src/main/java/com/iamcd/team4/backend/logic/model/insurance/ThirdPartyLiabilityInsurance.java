package com.iamcd.team4.backend.logic.model.insurance;

public class ThirdPartyLiabilityInsurance extends Insurance {

    public ThirdPartyLiabilityInsurance(double price) {
        super(price);
        this.name = "Third Party Liability Insurance";
        this.description = "TPL Insurance that covers damages upto $100,000";
        this.pricePer = "Year";
    }
}
