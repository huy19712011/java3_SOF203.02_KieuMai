package com.mycompany.java3_sof203._kieumai.jdbc.preparedStatement;

import com.mycompany.java3_sof203._kieumai.jdbc.DatabaseConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertingDemo {

    public static void main(String[] args) throws SQLException {
                DatabaseConnectionManager dcm
                = new DatabaseConnectionManager(
                        "test1",
                        "sa",
                        "123456");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = dcm.getConnection();

            String sql = """
                            INSERT INTO employees2(Id, Name, Salary)
                            VALUES (?, ?, ?);
                         """;

            preparedStatement = connection.prepareStatement(sql);

            // set values
            preparedStatement.setInt(1, 5);
            preparedStatement.setString(2, "Nam");
            preparedStatement.setDouble(3, 30000);

            // run query
            preparedStatement.executeUpdate();

            System.out.println("done...");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
    }
}
