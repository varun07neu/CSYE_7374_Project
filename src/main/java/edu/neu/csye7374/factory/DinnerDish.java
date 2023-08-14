package edu.neu.csye7374.factory;

import edu.neu.csye7374.abstractfactorypattern.IngredientAbstractFactory;
import edu.neu.csye7374.abstractfactorypattern.Sauce;
import edu.neu.csye7374.abstractfactorypattern.StandardIngredientFactory;
import edu.neu.csye7374.abstractfactorypattern.Vegetable;
import edu.neu.csye7374.factory.LunchDish.DishBuilder;

public class DinnerDish implements DishAPI {

	private String name;

	private double price;

	private IngredientAbstractFactory ingredientFactory;

	public DinnerDish(String name, double price) {
		super();
		this.name = name;
		this.price = price;
		this.ingredientFactory = new StandardIngredientFactory();
	}

	public DinnerDish(DishBuilder itemBuilder) {
		this.name = itemBuilder.name;
		this.price = itemBuilder.price;
		this.ingredientFactory = new StandardIngredientFactory();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public DinnerDish() {
		super();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	public void setIngredientFactory(IngredientAbstractFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	public void prepare() {
		System.out.println("Preparing Dinner Dish " + name);
		System.out.println("Fetching Ingredients From Ingredient Abstract Factory");
		Vegetable veg = ingredientFactory.createVegetable();
		Sauce sauce = ingredientFactory.createSauce();
		System.out.println("Veggie used " + veg);
		System.out.println("Sauce used " + veg);
	}

	@Override
	public void cook() {
		System.out.println("Cooking Dinner Dish " + name);

	}

	@Override
	public void serve() {
		System.out.println("Serving Dinner Dish " + name);
	}
	
	@Override
	public String toString() {
		return "DinnerDish [name=" + name + ", price=" + price + ", ingredientFactory=" + ingredientFactory + "]";
	}

	public static class DishBuilder {
		private String name;
		private double price;

		public DishBuilder() {

		}

		public DishBuilder(String name, double price) {
			super();
			this.name = name;
			this.price = price;
		}

		public DishBuilder name(String name) {
			this.name = name;
			return this;
		}

		public DishBuilder price(double price) {
			this.price = price;
			return this;
		}

		public double getPrice() {
			return price;
		}

		public String getName() {
			return name;
		}

	}

}
