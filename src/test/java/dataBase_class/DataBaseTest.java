package dataBase_class;

import Utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DataBaseTest {

    public static void main(String[] args) throws SQLException {

        JDBCUtils.establishConnection();

        List<Map<String, Object>> data = JDBCUtils.runQuery("Select * from employees order by employee_id");

        System.out.println( data.get(0).get("PHONE_NUMBER"));
        System.out.println(JDBCUtils.getCountRow());

        JDBCUtils.closeConnection();

        //---------------After we close the connection it throws SQLRecoverableException
        List<Map<String, Object>> data1 = JDBCUtils.runQuery("Select * from employees order by employee_id");
        System.out.println( data.get(0).get("PHONE_NUMBER"));
        System.out.println(JDBCUtils.getCountRow());


    }




}
