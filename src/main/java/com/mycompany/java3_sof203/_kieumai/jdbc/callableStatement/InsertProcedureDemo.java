package com.mycompany.java3_sof203._kieumai.jdbc.callableStatement;

import com.mycompany.java3_sof203._kieumai.jdbc.DatabaseConnectionManager;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertProcedureDemo {

    public static void main(String[] args) throws SQLException {
        DatabaseConnectionManager dcm
                = new DatabaseConnectionManager(
                        "test1",
                        "sa",
                        "123456");

        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;

        try {

            connection = dcm.getConnection();

            String proc = "{call insertEmployee(?,?,?)}";

            callableStatement = connection.prepareCall(proc);

            // set values
            callableStatement.setInt(1, 10);
            callableStatement.setString(2, "Nam");
            callableStatement.setDouble(3, 90000);

            // run query
            callableStatement.executeUpdate();

            System.out.println("done...");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            resultSet.close();
            callableStatement.close();
            connection.close();
        }
    }
}
