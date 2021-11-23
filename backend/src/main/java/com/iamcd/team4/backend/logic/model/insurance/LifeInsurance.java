package com.iamcd.team4.backend.logic.model.insurance;


import lombok.Data;

@Data
public class LifeInsurance extends Insurance  {

    public LifeInsurance(double price) {
        super(price);
        this.name = "Life Insurance Package";
        this.description = "A life insurance policy";
        this.pricePer = "Year";
    }
}
