package com.ejemplo.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

package com.miempresa.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC connection class used for the bootcamp project.
 *
 * IMPORTANT:
 * This file contains placeholder values. Anyone cloning this repository
 * must replace DB_URL, DB_USER and DB_PASS with their own local or cloud
 * MySQL credentials. Real credentials are intentionally NOT included.
 *
 * Steps for students:
 * 1. Create your own MySQL database (local or remote).
 * 2. Update the URL, username and password below.
 * 3. Make sure the MySQL Connector/J driver is active in your module.
 */
public class ConexionBD {

    // Replace these values with your own MySQL credentials
    private static final String DB_URL  = "jdbc:mysql://HOST:PORT/DATABASE?useSSL=true";
    private static final String DB_USER = "YOUR_USERNAME";
    private static final String DB_PASS = "YOUR_PASSWORD";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}

