package com.mycompany.java3_sof203._kieumai.jdbc.statement;

import com.mycompany.java3_sof203._kieumai.jdbc.DatabaseConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatingDemo {

    public static void main(String[] args) throws SQLException {
        DatabaseConnectionManager dcm
                = new DatabaseConnectionManager(
                        "test1",
                        "sa",
                        "123456");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            connection = dcm.getConnection();
            statement = connection.createStatement();

            String sql = """
                            UPDATE employees2
                            SET Name = 'New Name', Salary = 75000
                            WHERE Id = 1;
                         """;

            statement.executeUpdate(sql);

            System.out.println("done...");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            resultSet.close();
            statement.close();
            connection.close();
        }
    }
}
