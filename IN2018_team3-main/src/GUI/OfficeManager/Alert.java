package GUI.OfficeManager;

import javax.swing.*;

public class Alert {

    JFrame newFrame = new JFrame("Alert");
    JPanel panel = new JPanel();
    JLabel message = new JLabel();
    JButton ok = new JButton("Ok");

    public Alert(int alerts){
        panel.setLayout(null);

        message.setText("You have " + alerts + " new alerts.");

        newFrame.setSize(200, 200);
        panel.setSize(200,200);

        message.setVisible(true);
        message.setSize(200, 50);
        message.setLocation(20,0);

        ok.setSize(50,30);
        ok.setLocation((int)(panel.getWidth() * 0.4), (int)(panel.getHeight() * 0.6));
        ok.setVisible(true);
        ok.addActionListener(e -> {
            newFrame.dispose();
        });
        newFrame.setVisible(true);
        panel.setVisible(true);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.add(ok);
        panel.add(message);
        newFrame.add(panel);
    }

}
