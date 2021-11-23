package com.techelevator.farm;

public class Tractor extends FarmEquipment implements Singable {

    // The child class constructor is not required to have the same arguments type/number
    // as its parent class BUT it does need to call the parent constructor and pass in the
    // correct number and type of values.
    public Tractor() {
        // Passing in the same literal string name & purpose for all tractors.
        super("Tractor", "being useful around the farm");
    }

    @Override
    public String getSound() {
        return "Vroom vroom";
    }
}
