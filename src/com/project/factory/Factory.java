package com.project.factory;

import java.util.Scanner;
public abstract class Factory {
    // Declaration of instance variables 'name' and 'serviceLevel' with protected access
    protected String name;
    protected int serviceLevel;

    // Declaration of an instance variable 'sc' of type 'Scanner' for user input
    protected Scanner sc = new Scanner(System.in);

    // Declaration of an abstract method 'createContent' that takes a String parameter 'author'
    // The method returns an object of type 'IContent'
    public abstract IContent createContent(String author);
}
