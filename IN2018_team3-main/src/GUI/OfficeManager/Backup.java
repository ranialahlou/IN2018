package GUI.OfficeManager;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

public class Backup {
    JPanel panel = new JPanel();
    JLabel last = new JLabel("Last backup: ");
    JLabel lastBackup = new JLabel();
    JLabel frequency = new JLabel("Backup every: ");
    int option;
    String[] times = {"2 hours", "6 hours", "12 hours", "24 hours", "48 hours"};
    JComboBox backupSelection = new JComboBox(times);
    JButton restore = new JButton("Restore");
    JButton backup = new JButton("Backup");
    JButton save = new JButton("Save");
    FileReader read = null;
    BufferedReader reader = null;
    JButton back = new JButton("Back");

    //TODO - make automatic database backups at every specified interval

    public Backup(JPanel homeP, Connection conn) throws IOException {
        try {
            read = new FileReader("data/backupInfo.txt");
            reader = new BufferedReader(read);
            String line = reader.readLine();
            lastBackup.setText(line);
            line = reader.readLine();
            option = Integer.parseInt(line);

        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (read != null) {
                read.close();
            }
        }

        panel.setSize(400, 400);
        panel.setLocation(200, 0);
        panel.setLayout(null);
        panel.setVisible(true);

        last.setLocation(50, 100);
        last.setSize(90, 20);
        last.setVisible(true);

        lastBackup.setLocation(150, 100);
        lastBackup.setSize(200, 20);
        lastBackup.setVisible(true);

        frequency.setLocation(50, 150);
        frequency.setSize(90, 20);
        frequency.setVisible(true);

        backupSelection.setLocation(150, 150);
        backupSelection.setSize(120, 20);
        backupSelection.setVisible(true);
        backupSelection.setSelectedIndex(option);
        backupSelection.addActionListener( e -> {
            backupSelection.getSelectedItem();
        });

        save.setLocation(260, 260);
        save.setSize(100, 20);
        save.setVisible(true);
        save.addActionListener(e -> {
            try {
                FileWriter writer = new FileWriter("data/backupInfo.txt", false);
                writer.write(lastBackup.getText());
                writer.write("\r\n");
                Integer temp = backupSelection.getSelectedIndex();
                writer.write(temp.toString());
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        backup.setLocation(260, 300);
        backup.setSize(100, 20);
        backup.setVisible(true);
        backup.addActionListener(e -> {
            Process p = null;
            try {
                Runtime runtime = Runtime.getRuntime();
                p = runtime.exec("C:\\Program Files\\MySQL\\MySQL Server 5.6\\bin\\mysqldump -hjaytauron.xyz -P3306 -uteam3 -pwhoateallthebloodypies? --add-drop-database -B bapers -r " + "data\\" + "Backup" + ".sql");
                int processComplete = p.waitFor();
                JFrame temp = new JFrame("Backup status");
                if (processComplete == 0) {
                    JOptionPane.showMessageDialog(temp, "Backup successful!");
                } else {
                    JOptionPane.showMessageDialog(temp, "Could not backup the database.");
                }
            } catch (Exception exc) {
                exc.printStackTrace();
            }
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                lastBackup.setText(dtf.format(now));
                FileWriter writer = new FileWriter("data/backupInfo.txt", false);
                writer.write(lastBackup.getText());
                writer.write("\r\n");
                Integer temp = backupSelection.getSelectedIndex();
                writer.write(temp.toString());
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        restore.setLocation(50, 300);
        restore.setSize(100, 20);
        restore.setVisible(true);
        restore.addActionListener(e -> {
            String[] restoreCmd = new String[]{"C:\\Program Files\\MySQL\\MySQL Server 5.6\\bin\\mysql ", "-hjaytauron.xyz", "-P3306", "--user=" + "team3", "--password=" + "whoateallthebloodypies?", "-e", "source " + "data\\Backup.sql"};
            Process runtimeProcess;
            try {
                runtimeProcess = Runtime.getRuntime().exec(restoreCmd);
                int processComplete = runtimeProcess.waitFor();
                JFrame temp = new JFrame("Restore status");
                if (processComplete == 0) {
                    JOptionPane.showMessageDialog(temp, "Restore successful!");
                } else {
                    JOptionPane.showMessageDialog(temp, "Could not restore the database.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        back.setLocation(50, 260);
        back.setSize(100, 20);
        back.setVisible(true);
        back.addActionListener(e -> {
            homeP.remove(panel);
            homeP.repaint();
        });

        panel.add(last);
        panel.add(lastBackup);
        panel.add(frequency);
        panel.add(backupSelection);
        panel.add(save);
        panel.add(backup);
        panel.add(restore);
        panel.add(back);
        homeP.add(panel);
        homeP.repaint();

    }
}
