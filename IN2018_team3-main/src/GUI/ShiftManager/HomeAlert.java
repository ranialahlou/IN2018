package GUI.ShiftManager;

import GUI.OfficeManager.Alert;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class HomeAlert {

    JTable alerts = new JTable();
    JPanel newPanel = new JPanel();
    String[] columns = {"Name", "Job ID", "Alert"};

    public HomeAlert(JPanel panel, Connection conn) {

        newPanel.setVisible(true);
        newPanel.setSize(400, 400);
        newPanel.setLocation(200, 0);
        newPanel.setLayout(null);

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        alerts.setModel(model);
        alerts.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(alerts);

        try{
            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery("SELECT customer.FirstName, customer.LastName, job.JobID " +
                    "FROM customer, job " +
                    "WHERE job.AccountID = customer.AccountID AND " +
                    "job.Deadline < job.ExpectedDueDate");
            while(rs1.next()){
                model.addRow(new Object[] {rs1.getString(1) + " " + rs1.getString(2),
                        rs1.getString(3), "job running late"});
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        alerts.setBounds(30, 40, 200, 300);
        alerts.setVisible(true);
        scrollPane.setVisible(true);
        scrollPane.setLocation((int)(newPanel.getWidth()*0.125), (int)(newPanel.getHeight()*0.175));
        scrollPane.setSize(300, 250);
        newPanel.add(scrollPane);
        panel.add(newPanel);
        Alert al = new Alert(alerts.getRowCount());
    }
}
