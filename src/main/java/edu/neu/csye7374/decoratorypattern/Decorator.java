package edu.neu.csye7374.decoratorypattern;

import edu.neu.csye7374.factory.DishAPI;

public class Decorator implements DishAPI {

	private final static double PRICE = 1;

	@Override
	public double getPrice() {
		return PRICE;
	}

	@Override
	public String getName() {
		return "Adding Decorators";
	}

	@Override
	public void prepare() {
		
	}

	@Override
	public void cook() {
		
	}

	@Override
	public void serve() {
		
	}
	
	@Override
	public String toString() {
		return "Decorator [getPrice()=" + getPrice() + ", getName()=" + getName() + "]";
	}
}
