package edu.neu.csye7374.abstractfactorypattern;

public class Celery extends Vegetable{

    private final String name = "Celery";

    public Celery(int caloriesPerServing) {
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
