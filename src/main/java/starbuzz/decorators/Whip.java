package starbuzz.decorators;

import starbuzz.components.Beverage;

public class Whip extends Condiment {
    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String name() {
        return "Whip";
    }

    @Override
    public double extraCost() {
        return 0.10;
    }
}
