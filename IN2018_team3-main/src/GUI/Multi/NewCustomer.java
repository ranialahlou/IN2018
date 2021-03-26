package GUI.Multi;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class NewCustomer {

    private JPanel NCPanel = new JPanel();
    private JLabel nameL = new JLabel("Name: ");
    private JTextField name = new JTextField();
    private JLabel surnameL = new JLabel("Surname: ");
    private JTextField surname = new JTextField();
    private JLabel addressL = new JLabel("Address: ");
    private JTextField address = new JTextField();
    private JLabel numberL = new JLabel("Phone number: ");
    private JTextField number = new JTextField();
    private JLabel emailL = new JLabel("Email address: ");
    private JTextField email = new JTextField();
    private JButton save = new JButton("Save");

    public NewCustomer(JPanel panel, Connection conn){
        panel.setLayout(null);
        NCPanel.setLayout(null);
        NCPanel.setSize(400, 400);
        NCPanel.setLocation(200, 0);

        nameL.setLocation(10, 50);
        nameL.setSize(100, 20);
        nameL.setVisible(true);

        name.setLocation(100, 50);
        name.setSize(150, 20);
        name.setVisible(true);

        surnameL.setLocation(10, 70);
        surnameL.setSize(100, 20);
        surnameL.setVisible(true);

        surname.setLocation(100, 70);
        surname.setSize(150, 20);
        surname.setVisible(true);

        addressL.setLocation(10, 90);
        addressL.setSize(150, 20);
        addressL.setVisible(true);

        address.setLocation(100, 90);
        address.setSize(150, 20);
        address.setVisible(true);

        numberL.setLocation(10, 110);
        numberL.setSize(150, 20);
        numberL.setVisible(true);

        number.setLocation(100, 110);
        number.setSize(150, 20);
        number.setVisible(true);

        emailL.setLocation(10, 130);
        emailL.setSize(150, 20);
        emailL.setVisible(true);

        email.setLocation(100, 130);
        email.setSize(150, 20);
        email.setVisible(true);

        save.setLocation(250, 250);
        save.setSize(70, 20);
        save.setVisible(true);
        save.addActionListener(e -> {
            try{
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO customer VALUES()");

            } catch(Exception ex){
                ex.printStackTrace();
            }
        });

        addComps(NCPanel);
        panel.add(NCPanel);

    }

    public void addComps(JPanel panel){
        panel.add(nameL);
        panel.add(name);
        panel.add(surnameL);
        panel.add(surname);
        panel.add(addressL);
        panel.add(address);
        panel.add(numberL);
        panel.add(number);
        panel.add(emailL);
        panel.add(email);
        panel.add(save);
    }
}
