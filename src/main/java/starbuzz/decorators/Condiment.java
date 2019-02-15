package starbuzz.decorators;

import starbuzz.components.Beverage;

public abstract class Condiment extends Beverage {
    protected Beverage beverage;

    Condiment(Beverage beverage) {
        this.beverage = beverage;
    }
}
