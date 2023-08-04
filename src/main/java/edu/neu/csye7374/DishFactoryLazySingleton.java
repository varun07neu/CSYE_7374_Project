package edu.neu.csye7374;

import edu.neu.csye7374.Dish.DishBuilder;

public class DishFactoryLazySingleton implements AbstractDishFactory {
	
	private static DishFactoryLazySingleton instance;

	private DishFactoryLazySingleton() {
	}

	synchronized static DishFactoryLazySingleton getInstance() {
		if (instance == null) {
			instance = new DishFactoryLazySingleton();
		}
		return instance;
	}
	
	@Override
	public DishAPI createDish(String dishType) {
		return new Dish("Pizza", 13.3, dishType);
	}

	@Override
	public DishAPI createDish(DishBuilder dish) {
		return new Dish(dish);
	}

}
