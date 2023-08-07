package edu.neu.csye7374.command;

public class DiscardDishCommand implements KitchenCommandAPI{
    public KitchenActions receiver;

    public DiscardDishCommand(KitchenActions rec){
        receiver = rec;
    }

    @Override
    public void exec() {
        System.out.print("Kitchen update: ");
        receiver.inspectDish();
        System.out.println();
    }
}
