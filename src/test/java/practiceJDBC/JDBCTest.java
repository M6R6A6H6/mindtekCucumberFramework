package practiceJDBC;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {

        /**
         * We need 3 things 3 thing to connect to DATA BASE
         * 1. Connection Object
         * 2.Statement object
         * 3.ResultSet object
         *
         */


        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/HR_",
                "postgres",
                "Admin123");

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");
//       resultSet.next();
//        System.out.println(resultSet.getString(1));
//        resultSet.next();
//        int count=0;
//        while (resultSet.next()) {
//            count++;
//            System.out.println(resultSet.getString(2)+" " +resultSet.getString("last_name"));
////            String firstName = resultSet.getString("first_name");
//            String lastName = resultSet.getString("last_name");
//            System.out.println(firstName + " " + lastName);
//        }
//
        /**
         * ResultSetMetaData --> It holds data about data;
         */

         ResultSetMetaData metaData = resultSet.getMetaData();
         System.out.println(metaData.getColumnCount());
         System.out.println("Table name: "+metaData.getTableName(1));
         for(int i = 1; i<metaData.getColumnCount();i++)
         System.out.println("Column number: "+i+".Column name: " + metaData.getColumnName(i));
         










    }

}