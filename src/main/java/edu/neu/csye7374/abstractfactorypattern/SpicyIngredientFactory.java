package edu.neu.csye7374.abstractfactorypattern;

public class SpicyIngredientFactory implements IngredientAbstractFactory {
    @Override
    public Vegetable createVegetable() {
        return new RedPepper(90);
    }

    @Override
    public Sauce createSauce() {
        return new HotSauce("Hot",30);
    }
}
