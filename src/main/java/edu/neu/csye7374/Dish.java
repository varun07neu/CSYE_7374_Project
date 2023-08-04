package edu.neu.csye7374;

public class Dish implements DishAPI {

	private String name;
	private double price;
	private String dishType;

	public Dish(String name, double price, String dishType) {
		super();
		this.name = name;
		this.price = price;
		this.dishType = dishType;
	}


	public Dish(DishBuilder itemBuilder) {
		this.name = itemBuilder.name;
		this.price = itemBuilder.price;
		this.dishType = itemBuilder.dishType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", price=" + price + ", type=" +  dishType + "]";
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Dish clone() {
		return new Dish(this.getName(), this.getPrice(), this.dishType);
	}

	public static class DishBuilder {
		private String name;
		private double price;
		private String dishType;

		public DishBuilder() {

		}

		public DishBuilder(String name, double price, String dishType) {
			super();
			this.name = name;
			this.price = price;
			this.dishType = dishType;
		}

		public DishBuilder name(String name) {
			this.name = name;
			return this;
		}

		public DishBuilder price(double price) {
			this.price = price;
			return this;
		}
		
		public DishBuilder type(String dishType) {
			this.dishType = dishType;
			return this;
		}

		public double getPrice() {
			return price;
		}

		public String getName() {
			return name;
		}

		public String getDishType() {
			return dishType;
		}

	}

}
