package com.mycompany.java3_sof203._kieumai.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlDatabaseConnection {

    public static void main(String[] args) {

        String connectionUrl
                = "jdbc:sqlserver://localhost:1433;"
                + "database=test1;"
                + "user=sa;"
                + "password=123456;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";

        ResultSet result = null;

        try {
            Connection connection = DriverManager.getConnection(connectionUrl);
            System.out.println("Connected...");

            String sql = "SELECT * FROM sales.customers";

            Statement statement = connection.createStatement();

            result = statement.executeQuery(sql);

            while (result.next()) {
                System.out.println(result.getString("email"));
                System.out.println(result.getInt("customer_id"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
