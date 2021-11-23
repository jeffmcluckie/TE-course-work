package com.techelevator.farm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {

	public static void main(String[] args) {

		// Previously... we could only sing about FarmAnimals
		//FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken() };

		// NOW... we want to include a Tractor in our song too. INTERFACE to the rescue
		//        the new Singable[] below makes a new Array that holds Singables
		Singable[] singables = new Singable[] { new Cow(), new Chicken(), new Tractor() };

		// Just one Singable
		Singable someSingable = new Cow();

		// ----- Sing the song ----
		//for (FarmAnimal animal : farmAnimals) {
		for (Singable animal : singables) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();

		}

		// Done singing... let's sell some stuff
		Cow oldCow = new Cow();
		oldCow.setPrice(new BigDecimal(100.50));

		Egg anEgg = new Egg();
		Egg anotherEgg = new Egg();

		List<Sellable> stuffToSell = new ArrayList<>();
		stuffToSell.add(oldCow);
		stuffToSell.add(anEgg);
		stuffToSell.add(anotherEgg);

		for (Sellable item : stuffToSell) {
			//System.out.println("Selling off a " + item.getName() + " at " + item.getPrice());
			// Let's use format to make the price look nicer w/ 2 decimal places
			System.out.format("Selling off a %s at %.2f%n", item.getName(), item.getPrice());
		}
	}
}