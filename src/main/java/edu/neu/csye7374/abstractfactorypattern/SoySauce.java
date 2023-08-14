package edu.neu.csye7374.abstractfactorypattern;

public class SoySauce extends Sauce{

    private final String name = "Soy Sauce";

    public SoySauce(String spicyLevel, int caloriesPerServing) {
        this.spicyLevel = spicyLevel;
        this.caloriesPerServing = caloriesPerServing;
    }

    @Override
    public String displayProperties() {
         return this.name + " calories per serving " + this.caloriesPerServing;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
