package GUI.Multi;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CardPayment {
    private JPanel panel = new JPanel();
    private JButton back = new JButton("Back");
    private JButton save = new JButton("Save");
    private JTextField jobCode = new JTextField(20);
    private JLabel jobCodeText = new JLabel("Job Code: ");
    private JTextField taskID = new JTextField(20);
    private JLabel taskIdText = new JLabel("Task ID: ");
    private JTextField accountNumber = new JTextField(20);
    private JLabel accountNumberText = new JLabel("Account Number: ");
    private JTextField name = new JTextField(20);
    private JLabel nameText = new JLabel("Name: ");
    private JTextField address = new JTextField(20);
    private JLabel addressText = new JLabel("Address: ");
    private JTextField phoneNumber = new JTextField(20);
    private JLabel phoneNumberText = new JLabel("Phone Number: ");
    private JTextField email= new JTextField(20);
    private JTextField Date = new JTextField("Today's Date");
    private JLabel DateText = new JLabel("Today's Date: ");
    private JLabel emailText = new JLabel("Email: ");
    private JTextField discount= new JTextField(20);
    private JLabel discountText = new JLabel("Discount %: ");
    private JTextField price= new JTextField(20);
    private JLabel priceText = new JLabel("Price: ");
    private JTextField expiryDate= new JTextField(20);
    private JLabel expiryDateText = new JLabel("Expiry Date: ");
    private JTextField last4Digits= new JTextField(20);
    private JLabel last4DigitsText = new JLabel("Last 4 Digits: ");
    private JTextField cardType = new JTextField(20);
    private JLabel cardTypeText = new JLabel("Card Type: ");
    private JTextField amountPaid= new JTextField(20);
    private JLabel amountPaidText = new JLabel("Amount Paid: ");

    private JTextField PaymentID = new JTextField("Enter Payment ID");
    private JLabel PaymentIDText = new JLabel("PaymentID: ");

    private JLabel paymentTypeText = new JLabel("Payment Type: ");
    private JCheckBox checkbox = new JCheckBox("Cash");
    private JCheckBox checkbox2 = new JCheckBox("Card");
    private JTextField cardid = new JTextField("Enter CardID");
    private JLabel cardidtext = new JLabel("Enter CardID: ");
    private JTable table = new JTable();

    public CardPayment(JPanel mainPanel, Connection conn) {
        panel.setLayout(null);//means we can set exact positions of buttons/text etc...
        panel.setSize(600, 400);
        panel.setLocation(0,0);
        panel.setVisible(true);

        back.setLocation(170, 330);
        back.setSize(120, 30);
        back.setVisible(true);

        Date.setBounds(800, 100, 100, 25);
        DateText.setBounds(700, 100, 100, 25);
        PaymentID.setBounds(800, 125, 100, 25);
        PaymentIDText.setBounds(700, 125, 100, 25);
        cardid.setBounds(800, 150, 100, 25);
        cardidtext.setBounds(700, 150, 100, 25);

        save.setLocation(370, 330);
        save.setSize(100, 30);
        save.setVisible(true);

        jobCode.setLocation((int) (panel.getWidth() * 0.38), (int) (panel.getHeight() * 0.23));//228,92
        jobCode.setSize(100, 25);
        jobCode.setVisible(true);

        jobCodeText.setLocation((int) (panel.getWidth() * 0.28),  (int) (panel.getHeight() * 0.20));//168,80
        jobCodeText.setSize(200, 50);
        jobCodeText.setVisible(true);

        taskID.setLocation((int) (panel.getWidth() * 0.38), (int) (panel.getHeight() * 0.30));//228,120
        taskID.setSize(100, 25);
        taskID.setVisible(true);

        taskIdText.setLocation((int) (panel.getWidth() * 0.28),  (int) (panel.getHeight() * 0.27));//168,108
        taskIdText.setSize(200, 50);
        taskIdText.setVisible(true);

        accountNumber.setLocation((int) (panel.getWidth() * 0.47), (int) (panel.getHeight() * 0.37));
        accountNumber.setSize(100, 25);
        accountNumber.setVisible(true);

        accountNumberText.setLocation((int) (panel.getWidth() * 0.28),  (int) (panel.getHeight() * 0.34));//168,
        accountNumberText.setSize(200, 50);
        accountNumberText.setVisible(true);

        name.setLocation((int) (panel.getWidth() * 0.38), (int) (panel.getHeight() * 0.44));
        name.setSize(100, 25);
        name.setVisible(true);

        nameText.setLocation((int) (panel.getWidth() * 0.28),  (int) (panel.getHeight() * 0.41));
        nameText.setSize(200, 50);
        nameText.setVisible(true);

        address.setLocation((int) (panel.getWidth() * 0.69), (int) (panel.getHeight() * 0.23));
        address.setSize(100, 25);
        address.setVisible(true);

        addressText.setLocation((int) (panel.getWidth() * 0.59),  (int) (panel.getHeight() * 0.20));
        addressText.setSize(200, 50);
        addressText.setVisible(true);

        phoneNumber.setLocation((int) (panel.getWidth() * 0.75), (int) (panel.getHeight() * 0.30));
        phoneNumber.setSize(100, 25);
        phoneNumber.setVisible(true);

        phoneNumberText.setLocation((int) (panel.getWidth() * 0.59),  (int) (panel.getHeight() * 0.27));
        phoneNumberText.setSize(200, 50);
        phoneNumberText.setVisible(true);

        email.setLocation((int) (panel.getWidth() * 0.71), (int) (panel.getHeight() * 0.37));
        email.setSize(100, 25);
        email.setVisible(true);

        emailText.setLocation((int) (panel.getWidth() * 0.64),  (int) (panel.getHeight() * 0.34));
        emailText.setSize(200, 50);
        emailText.setVisible(true);

        discount.setLocation((int) (panel.getWidth() * 0.74), (int) (panel.getHeight() * 0.44));
        discount.setSize(100, 25);
        discount.setVisible(true);

        discountText.setLocation((int) (panel.getWidth() * 0.61),  (int) (panel.getHeight() * 0.41));
        discountText.setSize(200, 50);
        discountText.setVisible(true);

        price.setLocation((int) (panel.getWidth() * 0.70), (int) (panel.getHeight() * 0.51));
        price.setSize(100, 25);
        price.setVisible(true);

        priceText.setLocation((int) (panel.getWidth() * 0.62),  (int) (panel.getHeight() * 0.48));
        priceText.setSize(200, 50);
        priceText.setVisible(true);

        expiryDate.setLocation((int) (panel.getWidth() * 0.70), (int) (panel.getHeight() * 0.61));
        expiryDate.setSize(100, 25);
        expiryDate.setVisible(true);

        expiryDateText.setLocation((int) (panel.getWidth() * 0.57),  (int) (panel.getHeight() * 0.58));
        expiryDateText.setSize(200, 50);
        expiryDateText.setVisible(true);

        amountPaid.setLocation((int) (panel.getWidth() * 0.71), (int) (panel.getHeight() * 0.67));
        amountPaid.setSize(100, 25);
        amountPaid.setVisible(true);

        amountPaidText.setLocation((int) (panel.getWidth() * 0.57),  (int) (panel.getHeight() * 0.64));
        amountPaidText.setSize(200, 50);
        amountPaidText.setVisible(true);

        last4Digits.setLocation((int) (panel.getWidth() * 0.40), (int) (panel.getHeight() * 0.67));
        last4Digits.setSize(100, 25);
        last4Digits.setVisible(true);

        last4DigitsText.setLocation((int) (panel.getWidth() * 0.26),  (int) (panel.getHeight() * 0.64));
        last4DigitsText.setSize(200, 50);
        last4DigitsText.setVisible(true);

        cardType.setLocation((int) (panel.getWidth() * 0.38), (int) (panel.getHeight() * 0.60));
        cardType.setSize(100, 25);
        cardType.setVisible(true);

        cardTypeText.setLocation((int) (panel.getWidth() * 0.26),  (int) (panel.getHeight() * 0.57));
        cardTypeText.setSize(200, 50);
        cardTypeText.setVisible(true);

        paymentTypeText.setLocation((int) (panel.getWidth() * 0.27),  (int) (panel.getHeight() * 0.48));
        paymentTypeText.setSize(200, 50);
        paymentTypeText.setVisible(true);

        checkbox.setLocation((int) (panel.getWidth() * 0.42),  (int) (panel.getHeight() * 0.52));
        checkbox.setSize(80, 20);
        checkbox.setVisible(true);

        checkbox2.setLocation((int) (panel.getWidth() * 0.42),  (int) (panel.getHeight() * 0.6));
        checkbox2.setSize(80, 20);
        checkbox2.setVisible(true);

        JButton Confirm = new JButton("Confirm Payment");
        Confirm.setBounds(500, 200, 200, 25);

        panel.add(Confirm);
        panel.add(PaymentID);
        panel.add(PaymentIDText);
        panel.add(cardid);
        panel.add(cardidtext);
        panel.add(jobCode);
        panel.add(jobCodeText);
        panel.add(taskID);
        panel.add(taskIdText);
        panel.add(accountNumberText);
        panel.add(accountNumber);
        panel.add(name);
        panel.add(nameText);
        panel.add(address);
        panel.add(addressText);
        panel.add(phoneNumber);
        panel.add(Date);
        panel.add(DateText);
        panel.add(phoneNumberText);
        panel.add(email);
        panel.add(emailText);
        panel.add(discount);
        panel.add(discountText);
        panel.add(price);
        panel.add(priceText);
        panel.add(checkbox);
        panel.add(checkbox2);
        panel.add(paymentTypeText);
        panel.add(expiryDate);
        panel.add(expiryDateText);
        panel.add(last4Digits);
        panel.add(last4DigitsText);
        panel.add(amountPaid);
        panel.add(amountPaidText);
        panel.add(back);
        panel.add(save);
        panel.add(cardType);
        panel.add(cardTypeText);
        mainPanel.add(panel);

      Confirm.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              try {
                  Statement statement = conn.createStatement();
                  statement.executeUpdate("INSERT INTO payment (PaymentID, PaymentAmount, PaymentType, PaymentDate, JobJobID, JobAccountID)" + "VALUES ('" + PaymentID.getText() + "','" + amountPaid.getText() + "', 'Card' , '" + Date.getText() + "',' " + jobCode.getText() + "',' " + accountNumber.getText() +"')");
              } catch (SQLException throwables) {
                  throwables.printStackTrace();
              } try {
                  Statement statement = conn.createStatement();
                  statement.executeUpdate("INSERT INTO cardpayment (CardID, JobID, CardType, ExpiryDate, Last4Digits)" + "VALUES ('" + cardid.getText() + "','" +jobCode.getText() + "',' " + cardType.getText() + "',' " + expiryDate.getText() + "','" + last4Digits.getText() + "')");
              } catch (SQLException throwables) {
                  throwables.printStackTrace();
              }
          }

      });

    }

}


