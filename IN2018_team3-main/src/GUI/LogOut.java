package GUI;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class LogOut {
    public LogOut(JFrame frame, JPanel panel, Connection conn) {
        JButton logout = new JButton("Logout");
        logout.setSize(80, 30);
        logout.setLocation(500, 10);
        logout.setVisible(true);
        logout.addActionListener(e -> {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            frame.remove(panel);
            frame.remove(logout);
            frame.repaint();
            Login log = new Login(frame);

        });
        frame.add(logout);

    }
}
