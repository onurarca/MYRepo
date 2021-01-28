package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {

    /*
    establishConnection();
    runQuery(String query);
    getCountRow();
    closeConnection();

     */

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void establishConnection(){

        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@onursdbinstance.cjsdcgw9fkv5.us-east-2.rds.amazonaws.com:1521/ORCL",
                    "onurarca",
                    "Aws217055."
            );
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }catch (SQLException throwable){
            throwable.printStackTrace();
        }

    }

    public static List<Map<String,Object>> runQuery(String query) throws SQLException {

        resultSet = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        List<Map<String,Object>> data = new ArrayList<>();

        while (resultSet.next()){
            Map<String,Object> map = new LinkedHashMap<>();
            for (int i =1; i<=resultSetMetaData.getColumnCount(); i++){
                map.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
            }
            data.add(map);

        }
        return data;

    }

    public static int getCountRow() throws SQLException {
        resultSet.last();
        return resultSet.getRow();
    }

    public static void closeConnection() throws SQLException {
        if (connection!=null || statement!=null || resultSet!=null){
            connection.close();
            statement.close();
            resultSet.close();
        }

    }

}
