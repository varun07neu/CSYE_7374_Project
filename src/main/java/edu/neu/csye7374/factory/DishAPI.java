package edu.neu.csye7374.factory;

public interface DishAPI {

	String getName();

	double getPrice();
	
	void prepare();
	
	void cook();
	
	void serve();

//	DishAPI clone();

}
