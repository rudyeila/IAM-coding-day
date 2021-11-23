package com.iamcd.team4.backend.logic.model.insurance;

import lombok.Data;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Insurance {

    protected double price;
    protected String name;
    protected String description;
    private String validFrom;
    protected String pricePer;

    public Insurance(double price) {
        this.price = price;
        this.description = "A generic insurance offer";
        this.validFrom = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        this.name = "Generic insurance";
        this.pricePer = "Year";
    }

}
