package starbuzz.decorators;

import starbuzz.components.Beverage;

public class Mocha extends Condiment {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String name() {
        return "Mocha";
    }

    @Override
    public double extraCost() {
        return 0.2;
    }
}
