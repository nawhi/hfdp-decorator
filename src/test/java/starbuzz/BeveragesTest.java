package starbuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import starbuzz.components.*;
import starbuzz.decorators.*;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BeveragesTest {

    @Test
    void decaf_with_steamed_milk_and_whip_should_cost_1_25() {
        Beverage beverage = new Whip(new SteamedMilk(new Decaf()));
        assertEquals(1.25, beverage.cost(), 0.01);
    }

    @Test
    void espresso_with_mocha_should_cost_2_29() {
        Beverage beverage = new Mocha(new Espresso());
        assertEquals(2.19, beverage.cost(), 0.01);
    }

    @ParameterizedTest
    @MethodSource("coffeeCosts")
    void coffees_are_billed_correctly(Class<Beverage> component, Set<Class<Condiment>> decorators, double expectedCost) throws Exception {
        Beverage beverage = component.getConstructor().newInstance();

        for (var decorator: decorators) {
            beverage = decorator.getConstructor(Beverage.class).newInstance(beverage);
        }

        assertEquals(expectedCost, beverage.cost(), 0.01);
    }

    private static Stream<Arguments> coffeeCosts() {
        return Stream.of(
                Arguments.of(Espresso.class, Set.of(Mocha.class), 2.19)
        );
    }

    @ParameterizedTest
    @MethodSource("coffeeDescriptions")
    void coffees_are_described_correctly(Class<Beverage> component, Set<Class<Condiment>> decorators, String expectedDescription) throws Exception {
        Beverage beverage = component.getConstructor().newInstance();

        for (var decorator: decorators) {
            beverage = decorator.getConstructor(Beverage.class).newInstance(beverage);
        }

        assertEquals(expectedDescription, beverage.description());
    }

    private static Stream<Arguments> coffeeDescriptions() {
        return Stream.of(
                Arguments.of(Espresso.class, Set.of(Mocha.class), "Espresso + Mocha")
        );
    }
}