package starbuzz.decorators;

import starbuzz.components.Beverage;

import static java.lang.String.format;

public abstract class Condiment extends Beverage {
    protected Beverage beverage;

    Condiment(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String description() {
        return format("%s + %s", beverage.description(), name());
    }

    @Override
    public double cost() {
        return beverage.cost() + extraCost();
    }

    public abstract String name();
    public abstract double extraCost();
}
