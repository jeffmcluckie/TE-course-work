package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Make some HalloweenMonsters...

        // Making a variable for a Vampire allows it to drinkBlood
        // That is a Vampire specific thing to do. Not all HalloweenMonsters can do that...
        Vampire spike = new Vampire("Bill", 10);
        spike.drinkBlood();

        // Make more HalloweenMonsters
        Ghost casper = new Ghost("Julie", 7);
        Ghost marshmallow = new Ghost("Star", 9);
        Vampire angel = new Vampire("Thurm", 12);


        // Make a collection to hold all the monsters at the party
        // Here we want a generic type so that the party Vampires, Ghosts, etc
        List<HalloweenMonster> partyGuests = new ArrayList<>();
        partyGuests.add(spike);
        partyGuests.add(casper);
        partyGuests.add(marshmallow);
        partyGuests.add(angel);

        // Iterate over the list and show to command line
        for( HalloweenMonster monster : partyGuests ) {
            // Can call toString directly...
            //System.out.println(monster.toString());
            // BUT it is done by default to print, so don't need to it will happen automatically.
            System.out.println(monster);
        }
    }
}
