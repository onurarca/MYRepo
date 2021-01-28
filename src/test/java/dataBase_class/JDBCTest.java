package dataBase_class;

import java.sql.*;
import java.util.*;

public class JDBCTest {



    /*
    3 interfaces helps us connect our database

    Connection
    Statement
    ResultSet


     */


    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@onursdbinstance.cjsdcgw9fkv5.us-east-2.rds.amazonaws.com:1521/ORCL",
                "onurarca",
                "Aws217055.");

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet= statement.executeQuery("select * from employees order by employee_id");
        resultSet.next(); //it will give the first name
        //return type of the next() method is boolean
        //If there is next row it will navigate to the next row and return true.



        String first_name = resultSet.getString("first_name");
        System.out.println(first_name);
        String last_name = resultSet.getString("last_name");
        System.out.println(last_name);

        resultSet.last(); // it will go to the last row


        String fname = resultSet.getString("first_name");
        System.out.println(fname);

        resultSet.first();
        System.out.println(resultSet.getString("last_name"));

        System.out.println(resultSet.getString(1));

        System.out.println(resultSet.getRow());
        //getRow() methot will return the current Row Number

        resultSet.last();
        System.out.println(resultSet.getRow());

        System.out.println(resultSet.getObject("phone_number"));

        //=======================================RESULTSET METADATA==============================
        resultSet.beforeFirst();//**********************************
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        //ResultSetMetaData is storing all the table info related with the query;
        //Using get ColumnCount or getColumnName

        System.out.println(resultSetMetaData.getColumnName(4));
        System.out.println(resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(9));

        List<Map<String,Object>> data = new ArrayList<>();
        while(resultSet.next()){
            Map<String,Object> map = new LinkedHashMap<>();
            for (int i =1; i<resultSetMetaData.getColumnCount(); i++){
                map.put(resultSetMetaData.getColumnName(i),resultSet.getObject(i));
            }
            data.add(map);
        }

        System.out.println(data.get(0).get("EMAIL"));

    //Task --> print all email addresses from the list

        for (int i=0; i<data.size(); i++){
            System.out.println(data.get(i).get("EMAIL"));

        }

        for (int i=0; i<data.size(); i++) {
            for (int b =1; b<= resultSetMetaData.getColumnCount();b++){
                System.out.print(" " +data.get(i).get(resultSetMetaData.getColumnName(b)));
            }
            System.out.println();


        }







    }


}
