package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		List<Singable> singables =
				new ArrayList<>();
		singables.add(new Cow());
		singables.add(new Chicken());
		singables.add(new Pig());
		singables.add(new Tractor());

		// Make a new sleeping cow
		Cow betsie = new Cow();
		betsie.setAsleep(true);
		singables.add(betsie);

		// Make a Cats
		Cat abby = new Cat();
		abby.setAsleep(true);
		singables.add(abby);

		Cat kyo = new Cat();
		singables.add(kyo);

		// I can make an instance of a generic FarmAnimal...
		// this should not be possible! What is this thing???
		// Once we make it abstract, this gives an error
		//FarmAnimal farmAnimal = new FarmAnimal("What??", "honk");

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}
	}
}