package com.techelevator.farm;

import java.math.BigDecimal;

public class FarmAnimal implements Singable, Sellable {
	private String name;
	private String sound;
	private BigDecimal price;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String getSound() {
		return sound;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}