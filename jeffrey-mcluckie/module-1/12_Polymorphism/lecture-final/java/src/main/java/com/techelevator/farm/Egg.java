package com.techelevator.farm;

import java.math.BigDecimal;

public class Egg implements Sellable {

    private String name;
    private BigDecimal price;

    public Egg() {
        this.name = "Egg";
        this.price = new BigDecimal(.25);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
