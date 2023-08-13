package edu.neu.csye7374.factory;

//Lazy Singleton
public class LunchDishFactory implements DishFactory {
	
	private static LunchDishFactory instance;

	private LunchDishFactory() {
	}

	public synchronized static LunchDishFactory getInstance() {
		if (instance == null) {
			instance = new LunchDishFactory();
		}
		return instance;
	}
	
	@Override
	public DishAPI createDish(String name, double price) {
		return new LunchDish(name, price);
	}



}
