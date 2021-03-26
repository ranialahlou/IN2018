package GUI.OfficeManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Discounts {
    String[] DTypes = {"Fixed", "Variable", "Flexible"};
    int calculatedamount;
    String[] TMO = {"1 - 2", "3 - 4", "5+"};


    public Discounts(JPanel panel, Connection conn) {

      JComboBox DType = new JComboBox(DTypes);
      JComboBox TMonth = new JComboBox(TMO);
      JLabel DiscountType = new JLabel("Discount Type :");

      DType.setBounds(350, 100, 90, 25);
      DiscountType.setBounds(200, 100, 90, 25);
      panel.add(DType);
      panel.add(DiscountType);

      JButton Type = new JButton("Add This type");
      Type.setBounds(500, 100, 200, 25);
      panel.add(Type);


      JButton Create = new JButton("Create This Discount");
      Create.setBounds(500, 100, 200, 25);
      panel.add(Create);

      JButton Confirm = new JButton("Confirm This Discount");
      Confirm.setBounds(500, 200, 200, 25);

      JTextField AccountID = new JTextField("Enter AccountID");
      JTextField DAmount = new JTextField("Enter Discount Amount");
      JTextField TaskID = new JTextField("Enter TaskID");

      JLabel AccountID0 = new JLabel("AccountID :");
      JLabel TaskID0 = new JLabel("TaskID :");
      JLabel DiscountAmount= new JLabel("DiscountAmount :");
      JLabel TMON= new JLabel("Amount of Jobs for this customer This Month :");


        Type.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {

              JTextField DID = new JTextField("Enter DiscountID");
              JLabel DIDi = new JLabel("Discount ID :");
              DID.setBounds(350, 175, 90, 25);
              DIDi.setBounds(200, 175, 90, 25);
              panel.add(DID);
              panel.add(DIDi);

              if(DType.getSelectedItem() == "Fixed"){
                  AccountID.setBounds(350, 125, 90, 25);
                  DAmount.setBounds(350, 150, 90, 25);
                  AccountID0.setBounds(200, 125, 90, 25);
                  DiscountAmount.setBounds(200, 150, 90, 25);

                  panel.add(DAmount);
                  panel.add(AccountID);
                  panel.add(AccountID0);
                  panel.add(DiscountAmount);
                  panel.add(Confirm);
                  panel.repaint();

                  Confirm.addActionListener(new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent e) {
                          try {
                              Statement statement = conn.createStatement();
                              statement.executeUpdate("INSERT INTO discount " + "VALUES ('" + DID.getText() +"','Fixed', ' " + DAmount.getText()  + "')");
                          } catch (SQLException throwables) {
                              throwables.printStackTrace();
                          }  try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE))
                          {
                              ResultSet rs = stmt.executeQuery("select * from customer where AccountID = '" + AccountID.getText() + "'");
                              while(rs.next()) {
                                  rs.updateString("discountID", DID.getText());
                                  rs.updateRow();
                              }
                          } catch (SQLException e1) {
                              e1.printStackTrace();
                          }
                      }
                  });
              }



              if(DType.getSelectedItem() == "Variable") {
                  DAmount.setBounds(350, 150, 90, 25);
                  TaskID.setBounds(350, 125, 90, 25);
                  TaskID0.setBounds(200, 125, 90, 25);
                  DiscountAmount.setBounds(200, 150, 90, 25);

                  panel.add(DAmount);
                  panel.add(TaskID);
                  panel.add(DiscountAmount);
                  panel.add(TaskID0);
                  panel.add(Confirm);
                  panel.repaint();
                  Confirm.addActionListener(new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent e) {
                          try {
                              Statement statement = conn.createStatement();
                              statement.executeUpdate("INSERT INTO discount " + "VALUES ('" + DID.getText() + "','Variable', ' " + DAmount.getText() + "')");
                          } catch (SQLException throwables) {
                              throwables.printStackTrace();
                          }
                          try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                              ResultSet rs = stmt.executeQuery("select * from task where TaskID = '" + TaskID.getText() + "'");
                              while (rs.next()) {
                                  rs.updateString("discountID", DID.getText());
                                  rs.updateRow();
                              }
                          } catch (SQLException e1) {
                              e1.printStackTrace();
                          }
                      }
                  });
              }
              if(DType.getSelectedItem() == "Flexible"){

                  TMonth.setBounds(500, 150, 90, 25);
                  AccountID.setBounds(350, 125, 90, 25);
                  TMON.setBounds(200, 150, 300, 25);
                  AccountID0.setBounds(200, 125, 90, 25);

                  panel.add(TMON);
                  panel.add(TMonth);
                  panel.add(AccountID);
                  panel.add(AccountID0);
                  panel.add(Confirm);
                  panel.repaint();



                  Confirm.addActionListener(new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent e) {
                          if(TMonth.getSelectedItem() == "1 - 2")
                              calculatedamount = 9;

                          if(TMonth.getSelectedItem() == "3 - 4")
                              calculatedamount = 10;

                          if(TMonth.getSelectedItem() == "5+")
                              calculatedamount = 20;
                          try {
                              Statement statement = conn.createStatement();
                              statement.executeUpdate("INSERT INTO discount " + "VALUES ('" + DID.getText() + "','Flexible', ' " + calculatedamount + "')");
                          } catch (SQLException throwables) {
                              throwables.printStackTrace();
                          }
                          try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                              ResultSet rs = stmt.executeQuery("select * from customer where AccountID = '" + AccountID.getText() + "'");
                              while (rs.next()) {
                                  rs.updateString("discountID", DID.getText());
                                  rs.updateRow();
                              }
                          } catch (SQLException e1) {
                              e1.printStackTrace();
                          }
                      }
                  });

                  }
              }

      });

    }
}
