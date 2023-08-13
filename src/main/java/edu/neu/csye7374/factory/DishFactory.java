package edu.neu.csye7374.factory;

public interface DishFactory {
	
	DishAPI createDish(String name, double price);

//	DishAPI createDish(edu.neu.csye7374.DinnerDish.DishBuilder dish); 


}
