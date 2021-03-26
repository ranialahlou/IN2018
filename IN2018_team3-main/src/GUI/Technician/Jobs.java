package GUI.Technician;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Jobs {
    static Vector<Vector<String>> data = new Vector<Vector<String>>();
    static Vector<Vector<String>> newData = new Vector<Vector<String>>();
    String query =  "select job.JobID,job.Price, task.Instruction, task.TaskID, task.Department, task.StartTime, task.EndTime, task.Completed, staff.Name from ((job inner join task ON job.JOBID=task.JOBID) inner join staff ON task.StaffID=staff.StaffID) ";
    Statement stmt = null;


    public Jobs(JPanel panel, Connection conn) {
        Vector<String> coloumns = new Vector<String>();
        coloumns.add("JobID");
        coloumns.add("TaskID");
        coloumns.add("Department");
        coloumns.add("Status");
        coloumns.add("TimeStarted");
        coloumns.add("TimeEnded");
        coloumns.add("Description");
        coloumns.add("Price");


        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Vector<String> vstring = new Vector<String>();

                vstring.add(rs.getString("JobID"));
                vstring.add(rs.getString("TaskID"));
                vstring.add(rs.getString("Department"));
                vstring.add(rs.getString("Completed"));
                vstring.add(rs.getString("StartTime"));
                vstring.add(rs.getString("EndTime"));
                vstring.add(rs.getString("Instruction"));
                vstring.add(rs.getString("Price"));

                vstring.add("\n\n\n\n\n\n\n");
                data.add(vstring);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JTable jobs = new JTable(data,coloumns);
        //JTableHeader header = jobs.getTableHeader();
        JScrollPane pane = new JScrollPane(jobs);
        jobs.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JTextField newJobID = new JTextField("Enter Job Id");
        JTextField newTaskID = new JTextField("Enter Task ID");
        JTextField newDepartment = new JTextField("Enter Department");
        JTextField newStatus = new JTextField("Enter Status");
        JTextField newTimeStarted = new JTextField("Enter TimeStarted");
        JTextField newTimeEnded = new JTextField("Enter TimeEnded");
        JTextField newDescription = new JTextField("Enter Instruction");
        JTextField newPrice = new JTextField("Enter Price");

        JButton Update = new JButton("Update Row ");

        pane.setBounds(200,100,610,100);
        newJobID.setBounds(200, 200, 90, 25);
        newTaskID.setBounds(300, 200, 100, 25);
        newDepartment.setBounds(410, 200, 90, 25);
        newStatus.setBounds(510, 200, 90, 25);
        newPrice.setBounds(940, 200, 90, 25);
        newTimeStarted.setBounds(610, 200, 100, 25);
        newTimeEnded.setBounds(720, 200, 100, 25);
        newDescription.setBounds(830, 200, 100, 25);
        Update.setBounds(540, 230, 120, 25);

        panel.add(pane);
        panel.add(Update);
        panel.add(newJobID);
        panel.add(newTaskID);
        panel.add(newDepartment);
        panel.add(newStatus);
        panel.add(newPrice);
        panel.add(newTimeStarted);
        panel.add(newTimeEnded);
        panel.add(newDescription);
        pane.setVisible(true);

        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String updateQuery1 =  "Select * from job where JobID = '" + newJobID.getText() + "'";
                String updateQuery2 = "Select * from task where TaskID = '" + newTaskID.getText() +"'";
                try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE))
                {
                    ResultSet rs = stmt.executeQuery(updateQuery1);
                    while(rs.next()) {
                        //rs.updateString("JobID", newJobID.getText());
                        rs.updateString("Price", newPrice.getText());
                        rs.updateRow();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }  try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE))
                {
                    ResultSet rs = stmt.executeQuery(updateQuery2);
                    while(rs.next()) {
                       // rs.updateString("TaskID", newTaskID.getText());
                        rs.updateString("StartTime", newTimeStarted.getText());
                        rs.updateString("Endtime", newTimeEnded.getText());
                        rs.updateString("Instruction", newDescription.getText());
                        rs.updateString("Department", newDepartment.getText());
                        rs.updateString("Completed", newStatus.getText());
                        rs.updateRow();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                panel.remove(pane);
                panel.repaint();
                try {
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    while (rs.next()) {

                        Vector<String> vstring = new Vector<String>();

                        vstring.add(rs.getString("JobID"));
                        vstring.add(rs.getString("TaskID"));
                        vstring.add(rs.getString("Department"));
                        vstring.add(rs.getString("Completed"));
                        vstring.add(rs.getString("StartTime"));
                        vstring.add(rs.getString("EndTime"));
                        vstring.add(rs.getString("Instruction"));
                        vstring.add(rs.getString("Price"));

                        vstring.add("\n\n\n\n\n\n\n");
                        newData.add(vstring);
                    }
                } catch (SQLException a) {
                    a.printStackTrace();
                } JTable jobs = new JTable(newData, coloumns);
                JScrollPane pane = new JScrollPane(jobs);
                pane.setBounds(200,100,610,100);
                panel.add(pane);
            }
        });

    }
}
