package edu.neu.csye7374.factory;

public class LunchDish implements DishAPI {

	private String name;

	private double price;

	public LunchDish(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public LunchDish(DishBuilder itemBuilder) {
		this.name = itemBuilder.name;
		this.price = itemBuilder.price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LunchDish() {
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

	@Override
	public void prepare() {
		System.out.println("Preparing Dinner Dish " + name);

	}

	@Override
	public void cook() {
		System.out.println("Cooking Dinner Dish " + name);

	}

	@Override
	public void serve() {
		System.out.println("Serving Dinner Dish " + name);
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
