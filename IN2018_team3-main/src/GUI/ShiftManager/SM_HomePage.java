package GUI.ShiftManager;

import GUI.LogOut;
import GUI.Multi.NewCustomer;
import GUI.OfficeManager.Alert;
import GUI.Multi.CreateJob;
import GUI.Multi.CustomerSearch;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SM_HomePage {

    private JButton homeAlert = new JButton("Home/Alert");
    private JButton newCustomer = new JButton("New Customer");
    private JButton customerSearch = new JButton("Customer Search");
    private JButton jobSearch = new JButton("Job Search");
    private JButton createJob = new JButton("Create Job");
    private JButton reports = new JButton("Reports");
    private JLabel ShiftManager = new JLabel("<html>Shift Manager Home Page</html>");
    private JLabel bapersS = new JLabel("<html>Bloomsbury's Automated Process Execution Recording System</html>");
    private JPanel panel;
    boolean loginAlert = false;
    long start = System.currentTimeMillis();

    public SM_HomePage(JFrame frame, Connection conn){
        panel = new JPanel();
        panel.setLayout(null);//means we can set exact positions of buttons/text etc...
        panel.setSize(600, 400);
        if(System.currentTimeMillis() - start >= 900000 || !loginAlert) {
            int alerts = 0;
            try{
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) " +
                        "FROM customer, job " +
                        "WHERE job.AccountID = customer.AccountID AND " +
                        "job.Deadline < job.ExpectedDueDate");

                while(rs.next()){
                    alerts = rs.getInt(1);
                }

            }catch(Exception e){
                e.printStackTrace();
            }
            Alert al = new Alert(alerts);
            start = System.currentTimeMillis();
            loginAlert = true;
        }

        createJob.setLocation(30, 260);
        createJob.setSize(150, 20);
        createJob.setVisible(true);
        createJob.addActionListener(e -> {
            panel.removeAll();
            addComps(panel);
            //CreateJob creJ = new CreateJob(panel);
            frame.repaint();
        });

        homeAlert.setLocation(30, 100);
        homeAlert.setSize(150, 20);
        homeAlert.setVisible(true);
        homeAlert.addActionListener(e -> {
            panel.removeAll();
            addComps(panel);
            HomeAlert home = new HomeAlert(panel, conn);
            frame.repaint();
        });

        jobSearch.setLocation(30, 220);
        jobSearch.setSize(150, 20);
        jobSearch.setVisible(true);
        jobSearch.addActionListener(e -> {
            panel.removeAll();
            addComps(panel);
            //JobSearch jobS = new JobSearch(panel, conn);
            frame.repaint();
        });

        customerSearch.setLocation(30, 180);
        customerSearch.setSize(150, 20);
        customerSearch.setVisible(true);
        customerSearch.addActionListener(e -> {
            panel.removeAll();
            addComps(panel);
            //CustomerSearch custS = new CustomerSearch(panel);
            frame.repaint();
        });

        newCustomer.setLocation(30, 140);
        newCustomer.setSize(150, 20);
        newCustomer.setVisible(true);
        newCustomer.addActionListener(e -> {
            panel.removeAll();
            addComps(panel);
            //NewCustomer cust = new NewCustomer(panel);
            frame.repaint();
        });

        reports.setLocation(30, 300);
        reports.setSize(150, 20);
        reports.setVisible(true);
        reports.addActionListener(e -> {
            panel.removeAll();
            addComps(panel);
            //Reports rep = new Reports(panel);
            frame.repaint();
        });

        ShiftManager.setLocation(0,10);
        ShiftManager.setSize(100, 50);
        ShiftManager.setVisible(true);

        bapersS.setLocation(400,190);
        bapersS.setSize(200, 300);
        bapersS.setVisible(true);

        LogOut logout = new LogOut(frame, panel, conn);

        addComps(panel);

        frame.getContentPane().add(BorderLayout.CENTER, panel);

    }

    public void addComps(JPanel panel){
        panel.add(homeAlert);
        panel.add(newCustomer);
        panel.add(customerSearch);
        panel.add(jobSearch);
        panel.add(createJob);
        panel.add(reports);
        panel.add(ShiftManager);
        panel.add(bapersS);
    }
}
