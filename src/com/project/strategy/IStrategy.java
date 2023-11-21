package com.project.strategy;

import com.project.factory.IContent;

// IStrategy interface
public interface IStrategy {

    // Method signature for the action method, which takes a String parameter 'name'
    // and returns an object that implements the IContent interface
    IContent action(String name);
}
