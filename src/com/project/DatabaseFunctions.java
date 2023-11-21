package com.project;

import com.project.factory.IContent;
import com.project.singleton.DatabaseConnection;
import com.project.strategy.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// This class handles various database operations related to user management and content storage.

public class DatabaseFunctions {
    private DatabaseConnection db = DatabaseConnection.getInstance(); // Singleton pattern: Gets an instance of the database connection.
    private Connection conn = db.getConnection(); // Obtains the database connection.

    // Method to add a user to the database.
    void addUser(User user, String type) {
        try {
            Statement query = conn.createStatement();
            // Executes an SQL INSERT query to add a user to the specified type of table.
            query.executeUpdate("INSERT INTO public.\"" + type + "\" (name, password) VALUES ('" + user.getName() + "','" + user.getPassword() +"')");
            System.out.println(user.getName() + " successfully added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to check if a user exists in the specified type of table.
    boolean checkUser(User user, String type) {
        try {
            Statement statement = conn.createStatement();
            // Executes an SQL SELECT query to check if a user exists in the specified type of table.
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM \"" + type + "\" WHERE name = '" + user.getName() + "' AND password = '" + user.getPassword() + "';");
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to add an audio book content to the database.
    void addAudioBook(IContent podcast) {
        try {
            Statement statement = conn.createStatement();
            String chaptersString = "{" + String.join(", ", podcast.getChapters()) + "}";
            // Executes an SQL INSERT query to add an audiobook to the "Podcast" table.
            statement.executeUpdate("INSERT INTO \"Podcast\" (\"podcastName\", chapters, author, \"serviceLevel\") VALUES ('" + podcast.getName() + "','" + chaptersString + "','" + podcast.getAuthor() + "','" + podcast.getServiceLevel() + "')");
            System.out.println("Podcast added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a song content to the database.
    void addSong(IContent music) {
        try {
            Statement statement = conn.createStatement();
            // Executes an SQL INSERT query to add a song to the "Music" table.
            statement.executeUpdate("INSERT INTO \"Music\" (\"musicName\", author, \"serviceLevel\") VALUES ('" + music.getName() + "','" + music.getAuthor() + "','" + music.getServiceLevel() + "')");
            System.out.println("Music added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to display songs by a specific author.
    void showSong(String authorName) {
        try {
            // Executes an SQL SELECT query to retrieve songs by a specific author from the "Music" table.
            String query = String.format("SELECT * FROM public.\"Music\" WHERE author = '%s'", authorName);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("----------------------");
            while (resultSet.next()) {
                String musicName = resultSet.getString("musicName");
                String author = resultSet.getString("author");

                System.out.println("Music Name: " + musicName);
                System.out.println("Author: " + author);
                System.out.println("----------------------");
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to display audio books by a specific author.
    void showAudioBook(String authorName) {
        try {
            // Executes an SQL SELECT query to retrieve audio books by a specific author from the "Podcast" table.
            String query = String.format("SELECT * FROM public.\"Podcast\" WHERE author = '%s'", authorName);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("----------------------");
            while (resultSet.next()) {
                String audioBookName = resultSet.getString("podcastName");
                String[] chapters = resultSet.getString("chapters").split(", ");
                String author = resultSet.getString("author");

                System.out.println("Podcast Name: " + audioBookName);
                System.out.print("Chapters: ");
                for (int i = 0; i < chapters.length; i++) {
                    System.out.print(chapters[i]);
                    if (i < chapters.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("\nAuthor: " + author);
                System.out.println("----------------------");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to listen to a song based on access level.
    public void listenToMusic(int accessLevel, String songName) {
        try {
            Statement statement = conn.createStatement();
            // Executes an SQL SELECT query to check if the user has access to listen to a specific song.
            String query = String.format("SELECT * FROM public.\"Music\" WHERE \"musicName\" = '%s' AND \"serviceLevel\" <= %d", songName, accessLevel);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                System.out.printf("Listening to the %s by %s \n", resultSet.getString("musicName"), resultSet.getString("author"));
            } else {
                System.out.println("There is no such music or your access level is too low");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to listen to an audio book based on access level.
    public void listenToAudioBook(int accessLevel, String audioBookName) {
        try {
            Statement statement = conn.createStatement();
            // Executes an SQL SELECT query to check if the user has access to listen to a specific audio book.
            String query = String.format("SELECT * FROM public.\"Podcast\" WHERE \"podcastName\" = '%s' AND \"serviceLevel\" <= %d", audioBookName, accessLevel);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                System.out.printf("Listening to the '%s' by %s \n", resultSet.getString("podcastName"), resultSet.getString("author"));
                String[] chapters = resultSet.getString("chapters").split(",");
                for (int i = 0; i < chapters.length; i++) {
                    String cleanedChapter = chapters[i].trim().replaceAll("[{}]", "");
                    System.out.printf("Chapter %d: %s", i + 1, cleanedChapter);
                    if (i < chapters.length - 1) {
                        System.out.print("\n");
                    }
                }
                System.out.println();
            } else {
                System.out.println("There is no such podcast or your access level is too low");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get the access level of a user from the database.
    public int getAccessLevel(User user) {
        try {
            Statement statement = conn.createStatement();
            // Executes an SQL SELECT query to retrieve the access level of a user.
            String query = String.format("SELECT \"accessLevel\" FROM public.\"Listeners\" WHERE name = '%s'", user.getName());
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getInt("accessLevel");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Method to set the access level of a user in the database.
    public void setAccessLevel(User user, int accessLevel) {
        try {
            Statement statement = conn.createStatement();
            // Executes an SQL UPDATE query to set the access level of a user in the database.
            String updateQuery = String.format("UPDATE public.\"Listeners\" SET \"accessLevel\" = %d WHERE name = '%s'", accessLevel, user.getName());
            statement.executeUpdate(updateQuery);
            user.setAccessLevel(accessLevel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
