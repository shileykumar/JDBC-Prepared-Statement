package com.sunglowsys.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String dbUrl = "jdbc:mysql://localhost:3306/sunglowsys";
    private static final String username = "root";
    private static final String password = "root";

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(driverName);
                connection = DriverManager.getConnection(dbUrl, username, password);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return connection;
    }
}
