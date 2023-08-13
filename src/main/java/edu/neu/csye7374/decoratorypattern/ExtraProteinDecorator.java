package edu.neu.csye7374.decoratorypattern;

import edu.neu.csye7374.factory.DishAPI;

public class ExtraProteinDecorator extends Decorator{
	
	private final static double EXTRA_PROTEIN_PRICE = 15;

	private final static String EXTRA_PROTEIN_DESC = "Adding Extra Protein";
	
	private DishAPI dishAPI;

	
	public ExtraProteinDecorator(DishAPI dishAPI) {
		this.dishAPI = dishAPI;
	}
	
	@Override
	public double getPrice() {
		return dishAPI.getPrice() + EXTRA_PROTEIN_PRICE;
	}

	@Override
	public String getName() {
		return dishAPI.getName() + ", " +  EXTRA_PROTEIN_DESC;
	}

	@Override
	public String toString() {
		return "ExtraProteinDecorator [getPrice()=" + getPrice() + ", getName()=" + getName() + "]";
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
