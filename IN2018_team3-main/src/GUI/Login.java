package GUI;

import GUI.OfficeManager.OM_HomePage;
import GUI.Receptionist.R_HomePage;
import GUI.ShiftManager.SM_HomePage;
import GUI.Technician.T_HomePage;

import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class Login {

    private JButton login = new JButton("Login");
    private JPasswordField password = new JPasswordField(20);
    private JTextField username = new JTextField(20);
    private JLabel passwordText = new JLabel("Password: ");
    private JLabel usernameText = new JLabel("Username: ");
    private JLabel incorrectPass = new JLabel("Incorrect password. Please try again.");
    private JLabel incorrectUser = new JLabel("Incorrect username. Please try again.");
    private JLabel bapers = new JLabel("<html>Bloomsbury's Automated Process Execution Recording System</html>");
    private JPanel panel;

    public Login(JFrame frame){
        panel = new JPanel();
        panel.setLayout(null);//means we can set exact positions of buttons/text etc...
        panel.setSize(600, 400);

        login.setLocation((int) (panel.getWidth() * 0.6),  (int) (panel.getHeight() * 0.55));
        login.setSize(100, 50);
        login.setVisible(true);
        login.addActionListener(e -> {
            try {
                DatabaseConnection db = new DatabaseConnection();
                Connection conn = db.Connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT StaffType, password FROM staff WHERE username = '" + username.getText() + "'");//selects the users password from the database

                if(rs.next()) {

                    if (rs.getString(2).equals(password.getText())) {
                        System.out.println("GUI.Login successful!" + " " + rs.getString(1));
                        frame.remove(panel);
                        frame.repaint();
                        switch (rs.getString(1)){
                            case ("Office Manager"):
                                OM_HomePage home = new OM_HomePage(frame, conn);
                                break;
                            case("Shift Manager"):
                                SM_HomePage home1 = new SM_HomePage(frame, conn);
                                break;
                            case("Receptionist"):
                                R_HomePage home2 = new R_HomePage(frame, conn);
                                break;
                            case("Technician"):
                                T_HomePage home3 = new T_HomePage(frame, conn);
                                break;
                        }
                    }
                    else {
                        try{
                            panel.remove(incorrectUser);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        incorrectPass.setLocation((int) (panel.getWidth() * 0.52),  (int) (panel.getHeight() * 0.77));
                        incorrectPass.setSize(300, 25);
                        incorrectPass.setVisible(true);
                        incorrectPass.setForeground(Color.red);
                        panel.add(incorrectPass);
                        panel.repaint();
                        username.setText("");
                        password.setText("");
                    }
                }
                else {
                    try{
                        panel.remove(incorrectPass);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    incorrectUser.setLocation((int) (panel.getWidth() * 0.52),  (int) (panel.getHeight() * 0.75));
                    incorrectUser.setSize(300, 25);
                    incorrectUser.setVisible(true);
                    incorrectUser.setForeground(Color.red);
                    panel.add(incorrectUser);
                    panel.repaint();
                    username.setText("");
                    password.setText("");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        password.setLocation((int) (panel.getWidth() * 0.6), (int) (panel.getHeight() * 0.38));
        password.setSize(100, 25);
        password.setVisible(true);

        passwordText.setLocation((int) (panel.getWidth() * 0.45), (int) (panel.getHeight() * 0.35));
        passwordText.setSize(100, 50);
        passwordText.setVisible(true);

        username.setLocation((int) (panel.getWidth() * 0.6), (int) (panel.getHeight() * 0.2));
        username.setSize(100, 25);
        username.setVisible(true);

        usernameText.setLocation((int) (panel.getWidth() * 0.45),  (int) (panel.getHeight() * 0.17));
        usernameText.setSize(100, 50);
        usernameText.setVisible(true);

        bapers.setFont(new Font(bapers.getFont().getFontName(), Font.PLAIN, (int)(panel.getWidth()*0.05)));
        bapers.setLocation(10,0);
        bapers.setSize(200, 300);
        bapers.setVisible(true);

        addComps(panel);
        frame.add(panel);
    }

    public void addComps(JPanel panel){
        panel.add(login);
        panel.add(password);
        panel.add(username);
        panel.add(passwordText);
        panel.add(usernameText);
        panel.add(bapers);

    }
}
