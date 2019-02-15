package starbuzz.decorators;

import starbuzz.components.Beverage;

public class Soy extends Condiment {
    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description() + " + Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.15;
    }
}
