package edu.neu.csye7374.prototypepattern;

import edu.neu.csye7374.factory.DinnerDishFactory;

public class DinnerItem3 extends MenuItem{

    public DinnerItem3() {
        this.itemNo = 6;
        this.dish = DinnerDishFactory.getInstance().createDish("Spicy Chicken Curry",17.0);

    }

    @Override
    public void describe() {
        System.out.println("This is Dinner item 3 - " + this.dish);
    }
}
