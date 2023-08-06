package edu.neu.csye7374;

import java.util.List;

public class KitchenActions implements KitchenReceiverAPI{

    public List<DishAPI> dishes;

    public KitchenActions(List<DishAPI> d){
        dishes = d;
    }

    @Override
    public void makeDish() {
        for (DishAPI dish:
             dishes) {
            System.out.println(dish.getName() +" is being prepared");
        }
    }

    @Override
    public void inspectDish() {
        for (DishAPI dish:
                dishes) {
            System.out.println(dish.getName() + " is being checked for quality");
        }
    }

    @Override
    public void serveDish() {
        for (DishAPI dish:
                dishes) {
            System.out.println(dish.getName() + " is sent out to the table");
        }
    }

    @Override
    public void discardDish() {
        for (DishAPI dish:
                dishes) {
            System.out.println(dish.getName() + " is failed quality check and is being sent back");
        }
    }
}
