package com.techelevator.farm;


// Cats are perfect as they are, no subclassing allowed
// the final keyword prevents this
public final class Cat extends FarmAnimal {

    public Cat() {
        // Note that this sound is not getting used
        // because the getSound method is overriden
        super("Cat", "meow");
    }

    @Override
    public String eat() {
        return "ate a squirrel";
    }

    // We can't do this now because it is final in the FarmAnimal class
//    @Override
//    public String getSound() {
//        return "Meow!!!";
//    }
}
