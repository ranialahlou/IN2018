package GUI;

import java.sql.*;

public class CreateDatabase {

    public CreateDatabase(Connection conn){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO staff VALUES(NULL, 'Technician', 'Technician', 'Wanda Maximoff', 'Finish', 'Fine_touch')");

            ResultSet rs = stmt.executeQuery("SELECT * FROM staff");
            while(rs.next()){
                System.out.println(rs.getString(4));
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
