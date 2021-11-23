package com.iamcd.team4.backend.logic.model.insurance;

public class EquipmentInsurance extends Insurance {


    public EquipmentInsurance(double price) {
        super(price);
        this.name = "Equipment Insurance";
        this.description = "Insurance policy to cover various equipment";
        this.pricePer = "Day";
    }

}
