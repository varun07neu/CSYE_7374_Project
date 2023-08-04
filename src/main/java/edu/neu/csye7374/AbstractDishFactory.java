package edu.neu.csye7374;

import edu.neu.csye7374.Dish.DishBuilder;

public interface AbstractDishFactory {
	
	DishAPI createDish(String dishType);

	DishAPI createDish(DishBuilder dish); //TODO use DishBuilder

}
