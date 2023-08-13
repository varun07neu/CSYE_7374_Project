package edu.neu.csye7374.abstractfactorypattern;

public class StandardIngredientFactory implements IngredientAbstractFactory {
    @Override
    public Vegetable createVegetable() {
        return new Celery(250);
    }

    @Override
    public Sauce createSauce() {
        return new SoySauce("Mild",200);
    }
}
