package GUI.Multi;

import javax.swing.*;
import java.sql.Connection;

public class StaffReport {


    JPanel panel = new JPanel();
    private JButton back = new JButton("Back");
    private JButton create = new JButton("Create");
    private JButton logout = new JButton("Logout");
    private JCheckBox checkbox = new JCheckBox("Customer Report");
    private JCheckBox checkbox2 = new JCheckBox("Staff Report");
    private JCheckBox checkbox3 = new JCheckBox("Shift Report");
    private JTextField staffId = new JTextField(20);
    private JLabel staffIdText = new JLabel("Staff ID ");
    private JTextField startDate = new JTextField(20);
    private JLabel startDateText = new JLabel("Start Date ");
    private JTextField endDate = new JTextField(20);
    private JLabel endDateText = new JLabel("End Date ");


    public StaffReport(JFrame frame, Connection conn) {

        panel.setLayout(null);
        panel.setSize(600, 400);

        back.setLocation(170, 330);
        back.setSize(120, 30);
        back.setVisible(true);

        create.setLocation(370, 330);
        create.setSize(100, 30);
        create.setVisible(true);

        logout.setLocation(300, 200);
        logout.setSize(100, 50);
        logout.setVisible(true);

        checkbox.setLocation((int) (panel.getWidth() * 0.42),  (int) (panel.getHeight() * 0.40));
        checkbox.setSize(80, 20);
        checkbox.setVisible(true);

        checkbox2.setLocation((int) (panel.getWidth() * 0.42),  (int) (panel.getHeight() * 0.48));
        checkbox2.setSize(80, 20);
        checkbox2.setVisible(true);

        checkbox3.setLocation((int) (panel.getWidth() * 0.42),  (int) (panel.getHeight() * 0.56));
        checkbox3.setSize(80, 20);
        checkbox3.setVisible(true);

        staffId.setLocation((int) (panel.getWidth() * 0.42), (int) (panel.getHeight() * 0.64));
        staffId.setSize(100, 25);
        staffId.setVisible(true);

        staffIdText.setLocation((int) (panel.getWidth() * 0.42),  (int) (panel.getHeight() * 0.72));
        staffIdText.setSize(200, 50);
        staffIdText.setVisible(true);

        startDate.setLocation((int) (panel.getWidth() * 0.42), (int) (panel.getHeight() * 0.80));
        startDate.setSize(100, 25);
        startDate.setVisible(true);

        startDateText.setLocation((int) (panel.getWidth() * 0.42),  (int) (panel.getHeight() * 0.88));
        startDateText.setSize(200, 50);
        startDateText.setVisible(true);

        endDate.setLocation((int) (panel.getWidth() * 0.42), (int) (panel.getHeight() * 0.96));
        endDate.setSize(100, 25);
        endDate.setVisible(true);

        endDateText.setLocation((int) (panel.getWidth() * 0.42),  (int) (panel.getHeight() * 0.104));
        endDateText.setSize(200, 50);
        endDateText.setVisible(true);


        frame.add(panel);
        panel.add(back);
        panel.add(create);
        panel.add(checkbox);
        panel.add(checkbox2);
        panel.add(checkbox3);
        panel.add(staffId);
        panel.add(staffIdText);
        panel.add(startDate);
        panel.add(startDateText);
        panel.add(endDate);
        panel.add(endDateText);


    }

    public StaffReport(JPanel panel) {

    }
}

