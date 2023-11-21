package com.project.strategy;

import com.project.decorator.BasicAccessDecorator;
import com.project.decorator.IAccessLevelDecorator;
import com.project.factory.IContent;

import java.sql.SQLException;

/**
 * The User class represents a user in the system with a specific access level strategy.
 */
public class User {
    // The user's access level strategy
    private IAccessLevelDecorator user;

    // User's basic information
    private String name;
    private String password;
    private int accessLevel;

    /**
     * Constructor for creating a User with a specific access level strategy.
     *
     * @param strategy The access level strategy for the user.
     * @param name     The name of the user.
     * @param password The password of the user.
     */
    public User(IStrategy strategy, String name, String password) {
        // Wrap the basic strategy with a BasicAccessDecorator
        this.user = new BasicAccessDecorator(strategy);
        this.name = name;
        this.password = password;
    }

    /**
     * Performs an action based on the user's access level strategy.
     *
     * @return The result of the user's action.
     */
    public IContent action() {
        return user.action(name);
    }

    /**
     * Getter for the user's name.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the user's password.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for the user's access level.
     *
     * @param accessLevel The new access level for the user.
     */
    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    /**
     * Getter for the user's access level.
     *
     * @return The access level of the user.
     */
    public int getAccessLevel() {
        return accessLevel;
    }

    /**
     * Listens to content based on the user's access level.
     *
     * @throws SQLException If there is an issue with SQL operations.
     */
    public void listenToContent() throws SQLException {
        // Decorate the user's access level based on the strategy
        accessLevel = user.decorateAccessLevel(accessLevel);

        // Find the original strategy without decorators
        IStrategy originalStrategy = user;
        while (originalStrategy instanceof IAccessLevelDecorator) {
            originalStrategy = ((IAccessLevelDecorator) originalStrategy).getOriginalStrategy();
        }

        // Check if the original strategy allows listening to content
        if (originalStrategy instanceof Listener) {
            ((Listener) originalStrategy).listenToContent(accessLevel);
        } else {
            System.out.println("This user cannot listen to music.");
        }
    }
}
