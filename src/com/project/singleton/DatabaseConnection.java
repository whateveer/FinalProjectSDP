package com.project.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// DatabaseConnection class responsible for managing a single database connection
public class DatabaseConnection {

    // Static instance variable to hold the single instance of the class
    private static DatabaseConnection instance;

    // Database connection object
    private Connection connection;

    // Database connection parameters
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String user = "postgres";
    private String password = "whtvr";

    // Private constructor to prevent direct instantiation of the class
    private DatabaseConnection(){
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish a database connection using the specified parameters
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions related to driver loading or connection establishment
            e.printStackTrace();
        }
    }

    // Public method to get the single instance of the class (singleton pattern)
    public static DatabaseConnection getInstance(){
        // Create a new instance if it doesn't exist
        if (instance == null){
            instance = new DatabaseConnection();
        }
        // Return the existing instance
        return instance;
    }

    // Public method to retrieve the database connection
    public Connection getConnection() {
        return connection;
    }
}
