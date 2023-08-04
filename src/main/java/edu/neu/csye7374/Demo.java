package edu.neu.csye7374;

import java.util.*;

public class Demo {

	public static void demo() {

		List<DishAPI> dishes = new ArrayList<>();
		System.out.println("-------------- Creating dishes using Factory classes -----------------------");
		DishAPI cake = DishFactory.getInstance().createDish(DishType.MAINCOURSE.toString());

		DishAPI hamburger = DishFactoryEagerSingleton.getInstance().createDish(DishType.MAINCOURSE.toString());

		DishAPI pizza = DishFactoryLazySingleton.getInstance().createDish(DishType.MAINCOURSE.toString());

		DishAPI cheeseBurger = DishFactory.getInstance().createDish(
				new Dish.DishBuilder().name("Cheese Burger").price(10.0).type(DishType.MAINCOURSE.toString()));

		DishAPI iceCream = DishFactoryEagerSingleton.getInstance()
				.createDish(new Dish.DishBuilder().name("Ice Cream").price(10.0).type(DishType.DESSERT.toString()));

		DishAPI salad = DishFactoryLazySingleton.getInstance()
				.createDish(new Dish.DishBuilder().name("Salad").price(10.0).type(DishType.APPETIZER.toString()));

		dishes.add(cake);
		dishes.add(hamburger);
		dishes.add(cheeseBurger);
		dishes.add(salad);
		dishes.add(iceCream);
		dishes.add(pizza);

		for (DishAPI d : dishes) {
			System.out.println(d);
		}

        DishAPI clonedSalad = salad.clone();
        DishAPI clonedDessert = iceCream.clone();
        
        dishes.add(clonedDessert);
		dishes.add(clonedSalad);
		
		System.out.println("------------ Adding cloned dishes -----------");
		for (DishAPI d : dishes) {
			System.out.println(d);
		}
        
	}

}
