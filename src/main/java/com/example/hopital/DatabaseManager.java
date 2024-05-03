package com.example.hopital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static DatabaseManager instance;
    private Connection con;

    private DatabaseManager() {
        connect(); // Initialiser la connexion lors de la création de l'instance
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/java_hopital", "root", "");
            System.out.println("Connected to the database successfully!");
        } catch (ClassNotFoundException ex) {
            System.out.println("MySQL JDBC Driver not found.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Error connecting to the database.");
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return con;
    }

    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Database connection closed.");
            } catch (SQLException ex) {
                System.out.println("Error closing the database connection.");
                ex.printStackTrace();
            }
        }
    }
}
