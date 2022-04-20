package JDBC;

import utils.ConfigReader;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCIntro {

    /*
    *  Connection -> it will connect us to database allow us to enter our credentials
    *  Statement _> We define our conditions to get results from db
    * ResultSet -> We store the data from db to java object
    * Three of the above are interfaces in java which comes from jdbc dependency
    * */

    public static void main(String[] args) throws SQLException {
        //connection object from java.sql

        Connection connection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@aikerim.coskusb5pcq2.us-east-1.rds.amazonaws.com:1521/ORCL",
                        "aikerimMaster",
                         ConfigReader.readProperty("sqlpassword")
                );
//.TYPE_SCROLL_INSENSITIVE -intsantce variable form class
//        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        ResultSet resultSet = statement.executeQuery("select * from employees");
//        //java.sql.SQLException if ResultSet.next was not called
//        resultSet.next(); // will return true if there is a next row otherwise it will return false.
//        System.out.println( resultSet.getString("first_name"));
//        resultSet.next();
//        System.out.println( resultSet.getString("last_name"));
//        resultSet.next();
//        System.out.println(resultSet.getRow());
//
//        resultSet.last();
//        System.out.println(resultSet.getString("first_name"));






//        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//        ResultSet resultSet = statement.executeQuery("select first_name, email, department_name\n" +
//                "from employees e right join departments d\n" +
//                "on d.department_id = e.department_id");

// Create a connection before the statement and past this code in the main method it will work
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select first_name, email, department_name\n" +
                "from employees e right join departments d\n" +
                "on d.department_id = e.department_id");
        resultSet.next(); // will return true if there is a next row otherwise it will return false.
        // it will take us to the next row
        System.out.println(resultSet.getString("first_name"));
        // using get string we can get our column value from the row we are in
        System.out.println(resultSet.getRow());
        resultSet.next();
        System.out.println(resultSet.getRow());
        // If you want to go to the last row we could use resultSet.last() method
        resultSet.last();
        System.out.println(resultSet.getString("first_name"));
        resultSet.first(); //-> This method will take the row as first
        System.out.println(resultSet.getString("first_name"));
        //resultSet.deleteRow();// If we want to delete the row
        // MetaData
        ResultSetMetaData rSetMetaData = resultSet.getMetaData();
        // count of the columns for your table
        System.out.println(rSetMetaData.getColumnCount());
        System.out.println(rSetMetaData.getColumnName(1));// It gives column name in upper case
        // How can I print all the column names from employees table?
        for (int i = 1; i <=rSetMetaData.getColumnCount() ; i++) {
            System.out.println(rSetMetaData.getColumnName(i));
        }
        // Creating a map for one row
        Map<String,Object> oneRow= new HashMap();
        System.out.println(resultSet.getRow());
        for (int i = 1; i <=rSetMetaData.getColumnCount() ; i++) {
            oneRow.put(rSetMetaData.getColumnName(i),resultSet.getObject(i));
            // i is the number for column and our row number is defined by resultSet next method
            // to be able to get columnName we will use resultSetMeta data object wiht index number of column
            // to be able to get column's value we will use resultset.getObject method with index number of column
        }
       // System.out.println("maaap");
       // System.out.println(oneRow);
        List<Map<String,Object>> allTable= new ArrayList<>();
        while (resultSet.next()){
            Map<String,Object> currentRow= new HashMap();
            for (int i = 1; i <=rSetMetaData.getColumnCount() ; i++) {
                currentRow.put(rSetMetaData.getColumnName(i),resultSet.getObject(i));
                // i is the number for column and our row number is defined by resultSet next method
                // to be able to get columnName we will use resultSetMeta data object wiht index number of column
                // to be able to get column's value we will use resultset.getObject method with index number of column
                allTable.add(currentRow);
            }
        }
        System.out.println(allTable);








    }









}
