package GUI;

import java.sql.*;

public class DatabaseConnection {

    public DatabaseConnection() {
    }

    public Connection Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://jaytauron.xyz:3306/bapers", "team3", "whoateallthebloodypies?");//connecting to the MySQL database
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
