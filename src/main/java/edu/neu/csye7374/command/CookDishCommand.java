package edu.neu.csye7374.command;

public class CookDishCommand implements KitchenCommandAPI{

    public DishAPI receiver;

    public CookDishCommand(KitchenActions rec){
        receiver = rec;
    }

    @Override
    public void exec() {
        System.out.print("Kitchen update: ");
        receiver.cook();
        System.out.println();
    }
}
