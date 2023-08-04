package edu.neu.csye7374.abstractfactorypattern;

public interface IngredientAbstractFactory {
    Vegetable createVegetable();
    Sauce createSauce();
}
