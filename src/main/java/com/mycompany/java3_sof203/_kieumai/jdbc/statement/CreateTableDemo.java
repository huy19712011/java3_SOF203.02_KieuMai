package com.mycompany.java3_sof203._kieumai.jdbc.statement;

import com.mycompany.java3_sof203._kieumai.jdbc.DatabaseConnectionManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateTableDemo {

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
                           CREATE TABLE employees2(
                                Id INT NOT NULL,
                                Name NVARCHAR(30) NOT NULL,
                                Salary DECIMAL NOT NULL,
                                PRIMARY KEY(Id)
                           );
                         """;

            statement.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            resultSet.close();
            statement.close();
            connection.close();
        }
    }
}
