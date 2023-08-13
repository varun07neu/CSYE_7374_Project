package edu.neu.csye7374.factory;

import edu.neu.csye7374.factory.DinnerDish.DishBuilder;

public class DinnerDishFactory implements DishFactory {

	private static DinnerDishFactory instance = new DinnerDishFactory();

	private DinnerDishFactory() {
	}

	public synchronized static DinnerDishFactory getInstance() {
		return instance;
	}
	
//	@Override
//	public DishAPI createDish(DishBuilder dish) {
//		return new DinnerDish(dish);
//	}

	@Override
	public DishAPI createDish(String name, double price) {
		return new DinnerDish(name, price);
	}

}