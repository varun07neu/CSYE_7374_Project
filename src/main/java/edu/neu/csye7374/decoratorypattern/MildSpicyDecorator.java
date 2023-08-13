package edu.neu.csye7374.decoratorypattern;

import edu.neu.csye7374.factory.DishAPI;

public class MildSpicyDecorator extends Decorator {

	private final static double MILD_SPICY_PRICE = 3;

	private final static String MILD_SPICY_DESC = "Adding Less Spice";

	private DishAPI dishAPI;

	public MildSpicyDecorator(DishAPI dishAPI) {
		this.dishAPI = dishAPI;
	}

	@Override
	public double getPrice() {
		return dishAPI.getPrice() + MILD_SPICY_PRICE;
	}

	@Override
	public String getName() {
		return dishAPI.getName() + ", " + MILD_SPICY_DESC;
	}

	@Override
	public String toString() {
		return "MildSpicyDecorator [getPrice()=" + getPrice() + ", getDescription()=" + getName() + "]";
	}

	@Override
	public void cook() {
		dishAPI.cook();
	}

	@Override
	public void serve() {
		dishAPI.serve();
	}
}
