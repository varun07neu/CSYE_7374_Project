package edu.neu.csye7374;

import edu.neu.csye7374.Dish.DishBuilder;

public class DishFactoryEagerSingleton implements AbstractDishFactory {

	private static DishFactoryEagerSingleton instance = new DishFactoryEagerSingleton();

	private DishFactoryEagerSingleton() {
	}

	synchronized static DishFactoryEagerSingleton getInstance() {
		return instance;
	}

	@Override
	public DishAPI createDish(String dishType) {
		return new Dish("Ham Burger", 13.3, dishType);
	}

	@Override
	public DishAPI createDish(DishBuilder dish) {
		return new Dish(dish);
	}

}