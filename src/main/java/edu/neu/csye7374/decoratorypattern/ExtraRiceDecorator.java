package edu.neu.csye7374.decoratorypattern;

import edu.neu.csye7374.factory.DishAPI;

public class ExtraRiceDecorator extends Decorator {

	private final static double EXTRA_RICE_PRICE = 12;

	private final static String EXTRA_RICE_DESC = "Adding Extra Rice";

	private DishAPI dishAPI;

	public ExtraRiceDecorator(DishAPI dishAPI) {
		this.dishAPI = dishAPI;
	}

	@Override
	public double getPrice() {
		return dishAPI.getPrice() + EXTRA_RICE_PRICE;
	}

	@Override
	public String getName() {
		return dishAPI.getName() + ", " + EXTRA_RICE_DESC;
	}

	@Override
	public String toString() {
		return "ExtraRiceDecorator [getPrice()=" + getPrice() + ", getName()=" + getName() + "]";
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
