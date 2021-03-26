package GUI.Receptionist;

import GUI.LogOut;
import GUI.Multi.CreateJob;
import GUI.Multi.CustomerSearch;
import GUI.Multi.JobSearch;
import GUI.Multi.NewCustomer;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class R_HomePage {

    private JButton homeAlert = new JButton("Home/Alert");
    private JButton newCustomer = new JButton("New Customer");
    private JButton customerSearch = new JButton("Customer Search");
    private JButton jobSearch = new JButton("Job Search");
    private JButton createJob = new JButton("Create Job");
    private JLabel Receptionist = new JLabel("<html> Receptionist Home Page</html>");
    private JLabel bapersR = new JLabel("<html>Bloomsbury's Automated Process Execution Recording System</html>");
    private JPanel panel;

    public R_HomePage(JFrame frame, Connection conn){
        panel = new JPanel();
        panel.setLayout(null);//means we can set exact positions of buttons/text etc...
        panel.setSize(600, 400);

        createJob.setLocation(30, 260);
        createJob.setSize(150, 20);
        createJob.setVisible(true);
        createJob.addActionListener(e -> {
            panel.removeAll();//Means that you can actually navigate between different pages by pressing the navigation buttons
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
            //HomeAlert home = new HomeAlert(panel);
            frame.repaint();
        });

        jobSearch.setLocation(30, 220);
        jobSearch.setSize(150, 20);
        jobSearch.setVisible(true);
        jobSearch.addActionListener(e -> {
            panel.removeAll();
            addComps(panel);
            JobSearch jobS = new JobSearch(panel, conn);
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

        Receptionist.setLocation(480,20);
        Receptionist.setSize(100, 50);
        Receptionist.setVisible(true);

        bapersR.setLocation(0,-170);
        bapersR.setSize(400, 400);
        bapersR.setVisible(true);

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
        panel.add(Receptionist);
        panel.add(bapersR);
    }
}
