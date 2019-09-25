/**
 * Created by ronald on 28-9-2017.
 * Updated by ronald on 23-9-2019.
 */
 
package nl.saxion.jdbc;


//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelectLocal {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EMPLOYEES?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "admin";

    private JDBCSelectLocal() {
        throw new IllegalAccessError("Utility class");
    }

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection to  the database
            System.out.println("Opening a connection to  the database ...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Create a statement
            System.out.println("Creating a statement ...");
            statement = connection.createStatement();
            String sql;
            sql = "SELECT id, first, last, age FROM Registration";

            //STEP 5: Execute the statement
            resultSet = statement.executeQuery(sql);

            //STEP 6: extract data from result set
            System.out.println("Extracting data from result set ...");
            while (resultSet.next()) {
                //Retrieve by column name
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String first = resultSet.getString("first");
                String last = resultSet.getString("last");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }

            //STEP 7: Clean-up the environment
            System.out.println("Cleaning-up environment ...");
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }// nothing we can do
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }// nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        System.out.println("Goodbye!");
    }//end main
}//end JDBCSelectLocal

