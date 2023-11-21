package com.project.decorator;

import com.project.strategy.IStrategy;

// Definition of the 'IAccessLevelDecorator' interface, extending the 'IStrategy' interface
public interface IAccessLevelDecorator extends IStrategy {

    // Method signature for decorating an access level, taking the current access level as a parameter
    int decorateAccessLevel(int currentAccessLevel);

    // Method signature for getting the original strategy, returning an instance of 'IStrategy'
    IStrategy getOriginalStrategy();
}
