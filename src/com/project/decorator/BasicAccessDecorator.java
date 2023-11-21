package com.project.decorator;

import com.project.factory.IContent;
import com.project.strategy.IStrategy;

// BasicAccessDecorator is a decorator for access levels that does not modify the access level.
public class BasicAccessDecorator implements IAccessLevelDecorator {
    // The strategy that this decorator wraps.
    private IStrategy strategy;

    // Constructor that takes an IStrategy parameter to initialize the decorator.
    public BasicAccessDecorator(IStrategy strategy) {
        this.strategy = strategy;
    }

    // This method is from the IAccessLevelDecorator interface.
    // It decorates the access level by returning it unchanged.
    @Override
    public int decorateAccessLevel(int currentAccessLevel) {
        return currentAccessLevel;
    }

    // Getter method to retrieve the original strategy.
    @Override
    public IStrategy getOriginalStrategy() {
        return strategy;
    }

    // This method is from the IAccessLevelDecorator interface.
    // It delegates the action to the strategy it decorates.
    @Override
    public IContent action(String name) {
        return strategy.action(name);
    }
}
