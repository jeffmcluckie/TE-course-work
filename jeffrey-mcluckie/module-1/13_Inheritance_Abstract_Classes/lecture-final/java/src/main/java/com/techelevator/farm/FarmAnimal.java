package com.techelevator.farm;

/**
 * This class holds common behavior for all FarmAnimal subclasses
 * BUT we should not be able to make instances of this class itself.
 * That is why we made it abstract in the declaration below.
 */
public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;

	// new property to allow farm animals to sleep
	private boolean isAsleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		this.isAsleep = false; // this would be the default value anyway
	}

	// Just like abstract methods in an interface there is no body.
	// Each subclass will need to determine what it means to eat.
	// Every concrete subclass MUST implement this method (give it a body)
	public abstract String eat();

	public boolean isAsleep() {
		return isAsleep;
	}

	public void setAsleep(boolean asleep) {
		isAsleep = asleep;
	}

	public String getName( ) {
		return name;
	}

	// Made this final so it is guaranteed that every subclass
	// has this behavior work the same way.
	public final String getSound( ) {
		if (isAsleep()) {
			return "Zzzzz...";
		}
		return this.sound;
	}

}