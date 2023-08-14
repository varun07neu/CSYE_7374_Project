package edu.neu.csye7374.abstractfactorypattern;

public class RedPepper extends Vegetable{

    private final String name = "Red Pepper";

    public RedPepper(int caloriesPerServing) {
        this.caloriesPerServing = caloriesPerServing;
    }

    @Override
    public String displayProperties() {
        return name + " calories per serving " + this.caloriesPerServing;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
