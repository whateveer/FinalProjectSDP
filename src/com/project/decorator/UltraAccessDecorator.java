package com.project.decorator;

import com.project.factory.IContent;
import com.project.strategy.IStrategy;

// Declaration of the UltraAccessDecorator class implementing IAccessLevelDecorator interface
public class UltraAccessDecorator implements IAccessLevelDecorator {

    // Private field to hold the strategy instance
    private IStrategy strategy;

    // Constructor for UltraAccessDecorator, taking an IStrategy parameter
    public UltraAccessDecorator(IStrategy strategy) {
        // Assign the passed strategy to the private field
        this.strategy = strategy;
    }

    // Implementation of the decorateAccessLevel method from IAccessLevelDecorator interface
    @Override
    public int decorateAccessLevel(int currentAccessLevel) {
        // Ensure the decorated access level is at least 3
        return Math.max(3, currentAccessLevel);
    }

    // Implementation of the getOriginalStrategy method from IAccessLevelDecorator interface
    @Override
    public IStrategy getOriginalStrategy() {
        // Return the original strategy associated with this decorator
        return strategy;
    }

    // Implementation of the action method from IAccessLevelDecorator interface
    @Override
    public IContent action(String name) {
        // Delegate the action to the strategy's action method
        return strategy.action(name);
    }
}
