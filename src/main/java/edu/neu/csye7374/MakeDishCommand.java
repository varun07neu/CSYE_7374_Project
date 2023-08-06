package edu.neu.csye7374;

public class MakeDishCommand implements KitchenCommandAPI{

    public KitchenActions receiver;

    public MakeDishCommand(KitchenActions rec){
        receiver = rec;
    }

    @Override
    public void exec() {
        System.out.print("Kitchen update: ");
        receiver.makeDish();
        System.out.println();
    }
}
