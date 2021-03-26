package GUI.Technician;

import GUI.LogOut;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class T_HomePage {
    private JButton jobs = new JButton("Jobs");
    private JPanel panel;
    private JLabel Technician = new JLabel("<html>Technician Home Page</html>");
    private JLabel bapersT = new JLabel("<html>Bloomsbury's Automated Process Execution Recording System</html>");

    public T_HomePage(JFrame frame, Connection conn){
        panel = new JPanel();
        panel.setLayout(null);//means we can set exact positions of buttons/text etc...
        panel.setSize(600, 400);

        jobs.setLocation(5, 100);
        jobs.setSize(150, 20);
        jobs.setVisible(true);
        jobs.addActionListener(e -> {
            panel.removeAll();
            addComps(panel);
            Jobs jobs = new Jobs(panel, conn);
            frame.repaint();
        });

        Technician.setLocation(480,20);
        Technician.setSize(100, 50);
        Technician.setVisible(true);

        bapersT.setLocation(0,-170);
        bapersT.setSize(400, 400);
        bapersT.setVisible(true);

        LogOut logOut = new LogOut(frame, panel, conn);

        addComps(panel);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

    }

    public void addComps(JPanel panel){
        panel.add(jobs);
        panel.add(Technician);
        panel.add(bapersT);
    }
}
