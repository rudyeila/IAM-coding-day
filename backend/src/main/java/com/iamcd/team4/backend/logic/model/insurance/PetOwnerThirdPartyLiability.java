package com.iamcd.team4.backend.logic.model.insurance;

public class PetOwnerThirdPartyLiability extends ThirdPartyLiabilityInsurance {

    public PetOwnerThirdPartyLiability(double price) {
        super(price);
        this.name = "Pet Owners Third Party Liability Insurance";
        this.description = "TPL Insurance that covers damages upto $100,000 that are caused by your pets";
    }

}
