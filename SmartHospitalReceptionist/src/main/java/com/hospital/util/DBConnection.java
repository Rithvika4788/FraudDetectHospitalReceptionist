package com.hospital.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hospitaldb";
    private static final String USERNAME = "root";      // your MySQL username
    private static final String PASSWORD = "Rithvika@2505"; // your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
