package edu.neu.csye7374.prototypepattern;

import edu.neu.csye7374.factory.LunchDishFactory;

public class LunchItem3 extends MenuItem{

    public LunchItem3() {
        this.itemNo = 3;
        this.dish = LunchDishFactory.getInstance().createDish("Hunan Chicken",17.0);
    }

    @Override
    public void describe() {
        System.out.println("This is Lunch item 3 - " + this.dish);
    }
}
