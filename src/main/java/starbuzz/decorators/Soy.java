package starbuzz.decorators;

import starbuzz.components.Beverage;

public class Soy extends Condiment {
    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String name() {
        return "Soy";
    }

    @Override
    public double extraCost() {
        return 0.15;
    }
}
