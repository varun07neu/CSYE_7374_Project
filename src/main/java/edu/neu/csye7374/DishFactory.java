package edu.neu.csye7374;

import edu.neu.csye7374.Dish.DishBuilder;

public class DishFactory implements AbstractDishFactory {


		private static DishFactory instance;

		private DishFactory() {
		}

		public static synchronized DishFactory getInstance() {
			if (instance == null) {
				instance = new DishFactory();
			}
			return instance;
		}

		@Override
		public DishAPI createDish(String dishType) {
			return new Dish("Cake", 13.3, dishType);
		}

		@Override
		public DishAPI createDish(DishBuilder dish) {
			return new Dish(dish);
		}

}
