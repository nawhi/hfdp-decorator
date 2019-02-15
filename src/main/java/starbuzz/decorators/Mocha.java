package starbuzz.decorators;

import starbuzz.components.Beverage;

public class Mocha extends Condiment {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description() + " + Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + .2;
    }
}
