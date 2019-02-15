package starbuzz.decorators;

import starbuzz.components.Beverage;

public class Whip extends Condiment {
    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description() + " + Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }
}
