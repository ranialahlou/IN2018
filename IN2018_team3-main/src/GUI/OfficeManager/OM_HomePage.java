package GUI.OfficeManager;

//import GUI.NewCustomer;
//import GUI.Receptionist.CreateJob;
//import GUI.Receptionist.CustomerSearch;
//import GUI.Receptionist.JobSearch;

import GUI.LogOut;
import GUI.Multi.*;

import javax.swing.*;
import java.sql.*;

public class OM_HomePage {

    JPanel panel = new JPanel();
    JButton backup = new JButton("Backup");
    private JButton Discounts = new JButton("Add Discount");
    private JButton homeAlert = new JButton("Home/Alert");
    private JButton newCustomer = new JButton("New Customer");
    private JButton customerSearch = new JButton("Customer Search");
    private JButton jobSearch = new JButton("Job Search");
    private JButton CardPayment = new JButton("CardPayment");
    private JButton createJob = new JButton("Create Job");
    private JButton reports = new JButton("Reports");
    private JLabel OfficeManager = new JLabel("<html>Office Manager Home Page</html>");
    private JLabel bapersO = new JLabel("<html>Bloomsbury's Automated Process Execution Recording System</html>");
    boolean loginAlert = false;
    long start = System.currentTimeMillis();

    public OM_HomePage(JFrame frame, Connection conn){
        panel.setLayout(null);//means we can set exact positions of buttons/text etc...
        panel.setSize(600, 400);
        if(System.currentTimeMillis() - start >= 900000 || !loginAlert) {
            int alerts = 0;
            try{
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) " +
                        "FROM customer, job " +
                        "WHERE job.AccountID = customer.AccountID AND " +
                        "(job.Paid = 'no' AND job.ExpectedDueDate < DATE_SUB(NOW(), INTERVAL 30 DAY)) "+
                        "OR job.Deadline < job.ExpectedDueDate");

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


        createJob.setLocation(50, 260);
        createJob.setSize(150, 20);
        createJob.setVisible(true);
        createJob.addActionListener(e -> {
            panel.removeAll();//Means that you can actually navigate between different pages by pressing the navigation buttons
            addComps(panel);
            CreateJob creJ = new CreateJob(panel, conn);
            frame.repaint();
        });

        homeAlert.setLocation(50, 100);
        homeAlert.setSize(150, 20);
        homeAlert.setVisible(true);
        homeAlert.addActionListener(e -> {
            panel.removeAll();//Means that you can actually navigate between different pages by pressing the navigation buttons
            addComps(panel);
            HomeAlertOM home = new HomeAlertOM(panel, conn);
            frame.repaint();
        });

        jobSearch.setLocation(50, 220);
        jobSearch.setSize(150, 20);
        jobSearch.setVisible(true);
        jobSearch.addActionListener(e -> {
            panel.removeAll();//Means that you can actually navigate between different pages by pressing the navigation buttons
            addComps(panel);
            JobSearch jobS = new JobSearch(panel, conn);
            frame.repaint();
        });

        Discounts.setLocation(50, 380);
        Discounts.setSize(150, 20);
        Discounts.setVisible(true);
        Discounts.addActionListener(e -> {
            panel.removeAll();//Means that you can actually navigate between different pages by pressing the navigation buttons
            addComps(panel);
            Discounts Discount = new Discounts(panel, conn);
            frame.repaint();
        });

        customerSearch.setLocation(50, 180);
        customerSearch.setSize(150, 20);
        customerSearch.setVisible(true);
        customerSearch.addActionListener(e -> {
            panel.removeAll();//Means that you can actually navigate between different pages by pressing the navigation buttons
            addComps(panel);
            CustomerSearch custS = new CustomerSearch(panel, conn);
            frame.repaint();
        });

        newCustomer.setLocation(50, 140);
        newCustomer.setSize(150, 20);
        newCustomer.setVisible(true);
        newCustomer.addActionListener(e -> {
            panel.removeAll();//Means that you can actually navigate between different pages by pressing the navigation buttons
            addComps(panel);
            NewCustomer cust = new NewCustomer(panel, conn);
            frame.repaint();
        });
        OfficeManager.setLocation(0,10);
        OfficeManager.setSize(100, 50);
        OfficeManager.setVisible(true);

        bapersO.setLocation(400,190);
        bapersO.setSize(200, 300);
        bapersO.setVisible(true);

        reports.setLocation(50, 300);
        reports.setSize(150, 20);
        reports.setVisible(true);
        reports.addActionListener(e -> {
            panel.removeAll();//Means that you can actually navigate between different pages by pressing the navigation buttons
            addComps(panel);
            Reports rep = new Reports(panel);
            frame.repaint();
        });

        backup.setLocation(50, 340);
        backup.setSize(150, 20);
        backup.setVisible(true);
        backup.addActionListener(e -> {
            panel.removeAll();//Means that you can actually navigate between different pages by pressing the navigation buttons
            addComps(panel);
            try {
                Backup back = new Backup(panel, conn);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            frame.repaint();
        });

        CardPayment.setLocation(50, 420);
        CardPayment.setSize(150, 20);
        CardPayment.setVisible(true);
        CardPayment.addActionListener(e -> {
            panel.removeAll();//Means that you can actually navigate between different pages by pressing the navigation buttons
            addComps(panel);
            try {
                CardPayment CardPayment = new CardPayment(panel, conn);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            frame.repaint();
        });

        LogOut logout = new LogOut(frame, panel, conn);//DO NOT CHANGE!! This is the logout button that actually works!

        addComps(panel);
        frame.add(panel);
    }

    public void addComps(JPanel panel){
        panel.add(backup);
        panel.add(CardPayment);
        panel.add(Discounts);
        panel.add(homeAlert);
        panel.add(newCustomer);
        panel.add(customerSearch);
        panel.add(jobSearch);
        panel.add(createJob);
        panel.add(reports);
        panel.add(OfficeManager);
        panel.add(bapersO);
    }
}
