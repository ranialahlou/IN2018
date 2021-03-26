package GUI.Multi;

import javax.swing.*;
import java.sql.*;

public class CustomerSearch {

    private JRadioButton name = new JRadioButton("Name");
    private JRadioButton accountNo = new JRadioButton("Account Number");
    private ButtonGroup accountSearch = new ButtonGroup();
    private JTextField nameSearch = new JTextField();
    private JTextField numberSearch = new JTextField();
    private JButton search = new JButton("Search");

    public CustomerSearch(JPanel panel, Connection conn) {
        accountSearch.add(name);
        accountSearch.add(accountNo);

        search.setLocation(250, 250);
        search.setSize(50, 20);
        search.setVisible(true);
        search.addActionListener(e -> {
            try{
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE AccountID = " + numberSearch.getText() + " OR " +
                        "FirstName + LastName = " + nameSearch.getText() + ";");

            } catch (Exception ex){
                ex.printStackTrace();
            }
        });


    }

    public void addComps(JPanel panel){
        panel.add(name);
        panel.add(accountNo);
        panel.add(search);
    }
}
