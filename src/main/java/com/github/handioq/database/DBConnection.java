package com.github.handioq.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    //private static final String URL = "jdbc:mysql://localhost:3306/dbtest?autoReconnect=true&useSSL=true";
    //private static final String USERNAME = "root";
    //private static final String PASSWORD = "root";

    private static final String URL = "jdbc:mysql://hopper.beget.com:3306/j291069d_android?autoReconnect=true&useSSL=true";
    private static final String USERNAME = "j291069d_android";
    private static final String PASSWORD = "286Z24hgf2";

    private Connection connection;

    public DBConnection()
    {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            /*if (!connection.isClosed())
            {
                System.out.println("Соединение с БД установлено.");
            }*/
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.err.println("Error");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isConnected()
    {
        boolean result = true;

        try {
            if (!connection.isClosed())
            {
                System.out.println("Соединение с БД установлено.");
            }
            else
            {
                result = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    public void closeConnection()
    {
        try
        {
            connection.close();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}