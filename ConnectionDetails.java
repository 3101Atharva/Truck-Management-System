package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDetails {
    //public static String LOAD_Driver = "com.mysql.cj.jdbc.Driver";

    public static final String URL = "jdbc:mysql://localhost:3306/TruckMgt";

    public static final String PASSWORD = "Atharva@1616";

    public static final String USERNAME = "root";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}

