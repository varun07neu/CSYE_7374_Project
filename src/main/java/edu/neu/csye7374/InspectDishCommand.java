package edu.neu.csye7374;

public class InspectDishCommand implements KitchenCommandAPI{
    public KitchenActions receiver;

    public InspectDishCommand(KitchenActions rec){
        receiver = rec;
    }

    @Override
    public void exec() {
        System.out.print("Kitchen update: ");
        receiver.inspectDish();
        System.out.println();
    }
}
