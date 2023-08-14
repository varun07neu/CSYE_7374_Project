package edu.neu.csye7374.prototypepattern;

import edu.neu.csye7374.factory.DinnerDishFactory;

public class DinnerItem2 extends MenuItem{

    public DinnerItem2() {
        this.itemNo = 5;
        this.dish = DinnerDishFactory.getInstance().createDish("Broccoli Soy Sauce",15.0);
    }

    @Override
    public void describe() {
        System.out.println("This is Dinner item 2 - " + this.dish);
    }
}
