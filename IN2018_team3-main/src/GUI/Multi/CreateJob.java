package GUI.Multi;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class CreateJob {

    private JPanel thisPanel = new JPanel();
    private JRadioButton newCust = new JRadioButton("New Customer");
    private JRadioButton existingCust = new JRadioButton("Existing Customer");
    private ButtonGroup customer = new ButtonGroup();
    private JButton search = new JButton("Search");
    private JLabel custName = new JLabel("Customer name: ");
    private JLabel custAccNo = new JLabel("Account number: ");
    private String[] times = {"48 hours", "24 hours", "12 hours", "6 hours", "3 hours", "2 hours"};
    private JComboBox<String> urgency = new JComboBox(times);
    private JTextArea extraInfo = new JTextArea();

    public CreateJob(JPanel panel, Connection conn) {
        thisPanel.setSize(400, 400);
        thisPanel.setLocation(200, 0);
        thisPanel.setLayout(null);
        thisPanel.setVisible(true);

        customer.add(newCust);
        customer.add(existingCust);

        newCust.setLocation(10, 60);
        newCust.setSize(150, 20);
        newCust.setVisible(true);
        newCust.addActionListener(e -> {

        });

        existingCust.setLocation(10, 90);
        existingCust.setSize(150, 20);
        existingCust.setVisible(true);
        existingCust.addActionListener(e -> {

        });


        addComps(thisPanel);
        panel.add(thisPanel);

    }

    public void addComps(JPanel panel){
        panel.add(newCust);
        panel.add(existingCust);

    }
}
