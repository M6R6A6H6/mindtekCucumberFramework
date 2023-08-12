package utilities;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class JDBCUtils {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

   public static void establishConnection() throws SQLException {
        connection = DriverManager.getConnection(
                ConfigReader.getProperty("DBURL"),
                ConfigReader.getProperty("DBUserName"),
                ConfigReader.getProperty("DBPassword"));

        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

    }

    public static List<Map<String, Object>> runQuery(String query) throws SQLException {
       // resultSet = statement.executeQuery("select * from yards");


        List<Map<String, Object>>  tableData = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(query);


        ResultSetMetaData metaData = resultSet.getMetaData();
        while(resultSet.next()){

            Map<String, Object> rowData = new HashMap<>();

            for(int columnIndex=1; columnIndex<=metaData.getColumnCount(); columnIndex++){
                rowData.put(metaData.getColumnName(columnIndex), resultSet.getString(metaData.getColumnName(columnIndex)));
            }
            tableData.add(rowData);
        }



        return tableData;

    }

    public static void closeDatabase () throws SQLException {

        if (connection!=null){
            connection.close();
        }
        if (statement!=null){
            statement.close();
        }
        if (resultSet!=null){
            resultSet.close();
        }
    }
}