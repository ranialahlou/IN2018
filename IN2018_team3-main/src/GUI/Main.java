package GUI;

import GUI.DatabaseConnection;
import GUI.Multi.CardPayment;
import GUI.Multi.CashPayment;
import GUI.Multi.CreateJob;
import GUI.Multi.NewCustomer;
import GUI.OfficeManager.OM_HomePage;
//import GUI.Receptionist.R_CardPayment;
//import GUI.Receptionist.R_CashPayment;
//import GUI.ShiftManager.SM_CardPayment;
//import GUI.ShiftManager.SM_CashPayment;


import java.sql.*;


import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        Connection conn = db.Connect();
        //GUI.CreateDatabase d = new GUI.CreateDatabase(conn);
        //login
        JFrame frame = new JFrame("BAPERS");
        frame.setSize(600, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setSize(600, 400);
        panel.setLayout(null);
        frame.add(panel);
        //CreateJob cj = new CreateJob(panel, conn);
        //NewCustomer newCust = new NewCustomer(panel, conn);
        //Login login = new GUI.Login(frame);
        //OM_HomePage home = new OM_HomePage(frame, conn);
        // home page
       // R_HomePage homePage = new R_HomePage(frame,conn);
        //SM_HomePage homePage = new SM_HomePage(frame, conn);
       //T_HomePage homePage = new T_HomePage(frame, conn);
        //SM_CardPayment cardPayment = new SM_CardPayment(frame);
        //SM_CashPayment cashPayment = new SM_CashPayment(frame);
        //R_CashPayment r_cashPayment = new R_CashPayment(frame);
        //R_CardPayment r_cardPayment = new R_CardPayment(frame);
        //OM_CashPayment om_cashPayment = new OM_CashPayment(frame,conn);
        CashPayment om_cardPayment = new CashPayment(panel, conn);




        frame.setVisible(true);
    }
}
