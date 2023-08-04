package edu.neu.csye7374.abstractfactorypattern;

public class CrabMeat extends Meat{

    String crabType;

    public CrabMeat(String crabType, String type, int caloriesPerServing ) {
        this.crabType = crabType;
        this.type = "SeaFood";
        this.caloriesPerServing = 300;
    }

    @Override
    public String displayProperties() {
        return "Crab type is : " + this.crabType + " calories per serving is " + this.caloriesPerServing;
    }
}
