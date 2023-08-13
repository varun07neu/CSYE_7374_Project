package edu.neu.csye7374.decoratorypattern;

import edu.neu.csye7374.factory.DishAPI;

public class ExtraSpicyDecorator extends Decorator {

	private final static double EXTRA_SPICY_PRICE = 10;

	private final static String EXTRA_SPICY_DESC = "Adding Extra Spicy";

	private DishAPI dishAPI;

	public ExtraSpicyDecorator(DishAPI dishAPI) {
		this.dishAPI = dishAPI;
	}

	@Override
	public double getPrice() {
		return dishAPI.getPrice() + EXTRA_SPICY_PRICE;
	}

	@Override
	public String getName() {
		return dishAPI.getName() + ", " + EXTRA_SPICY_DESC;
	}

	@Override
	public String toString() {
		return "ExtraSpicyDecorator [getPrice()=" + getPrice() + ", getName()=" + getName() + "]";
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
