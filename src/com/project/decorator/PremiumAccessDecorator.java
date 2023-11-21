package com.project.decorator;

import com.project.factory.IContent;
import com.project.strategy.IStrategy;

// Definition of the PremiumAccessDecorator class implementing IAccessLevelDecorator interface
public class PremiumAccessDecorator implements IAccessLevelDecorator {

    private IStrategy strategy;

    // Constructor for the PremiumAccessDecorator class, takes an IStrategy as a parameter
    public PremiumAccessDecorator(IStrategy strategy) {
        this.strategy = strategy;
    }

    // Override method to decorate the access level, ensuring it is at least 2
    @Override
    public int decorateAccessLevel(int currentAccessLevel) {
        return Math.max(2, currentAccessLevel);
    }

    // Override method to get the original strategy
    @Override
    public IStrategy getOriginalStrategy() {
        return strategy;
    }

    // Override method to perform an action using the strategy, taking a name as a parameter
    @Override
    public IContent action(String name) {
        return strategy.action(name);
    }
}
