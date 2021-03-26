package GUI.Multi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class JobSearch extends JPanel {

    Statement stmt = null;
    String query =  "select job.JobID, task.Instruction, task.TaskID, task.Department, task.StartTime, task.Completed, staff.Name from ((job inner join task ON job.JOBID=task.JOBID) inner join staff ON task.StaffID=staff.StaffID) ";

    String[] Departments = {"Copy Room", "Development Area", "Finishing Room", "Dark Room", "Packing Department", "Laboratory"};
    String[] Statuses = {"Yes", "No", "Half"};

    static Vector<Vector<String>> data = new Vector<Vector<String>>();
    static Vector<Vector<String>> newData = new Vector<Vector<String>>();

    public JobSearch(JPanel panel, Connection conn) {

        //this.panel = new JPanel();
        //panel.add(CreateTable(conn, panel, query, 200, 200));
        Vector<String> coloumns = new Vector<String>();
        coloumns.add("JobID");
        coloumns.add("TaskID");
        coloumns.add("Department");
        coloumns.add("StartTime");
        coloumns.add("Completed");
        coloumns.add("Worked By");
        coloumns.add("Instruction");

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Vector<String> vstring = new Vector<String>();

                vstring.add(rs.getString("JobID"));
                vstring.add(rs.getString("TaskID"));
                vstring.add(rs.getString("Department"));
                vstring.add(rs.getString("StartTime"));
                vstring.add(rs.getString("Completed"));
                vstring.add(rs.getString("Name"));
                vstring.add(rs.getString("Instruction"));

                vstring.add("\n\n\n\n\n\n\n");
                data.add(vstring);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JTable jobs = new JTable(data, coloumns);
        JScrollPane pane = new JScrollPane(jobs);
        pane.setBounds(200,200,550,100);

        JLabel Jobs = new JLabel("Jobs");

        JTextField SearchID = new JTextField("Enter JobID");
        JLabel JobCode= new JLabel("Job Code :");
        JLabel Department= new JLabel("Department :");
        JLabel Status= new JLabel("CompletionStatus :");
        JComboBox SearchDepartment = new JComboBox(Departments);
        JComboBox SearchStatus = new JComboBox(Statuses);



        //JButton button = new JButton("Back");
        JButton Search = new JButton("Search");



        //button.setBounds(100, 200, 90, 50);
        Department.setBounds(200, 125, 90, 25);
        Status.setBounds(200, 150, 150, 25);
        JobCode.setBounds(200, 100, 90, 25);
        Jobs.setBounds(200,50, 50, 50);
        Search.setBounds(475, 100, 90, 25);
        SearchID.setBounds(350, 100, 90, 25);

        SearchDepartment.setBounds(350, 125, 90, 25);
        SearchStatus.setBounds(350, 150, 90, 25);

        /* JButton Refresh = new JButton("Refresh");
        Refresh.setBounds(200, 200, 90, 50);
        frame.add(Refresh);

       Refresh.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JobSearch jobS = new JobSearch(frame, conn);
               frame.repaint();           }
       });*/

        // adds button in JFrame
        // frame.add(button);
        panel.add(Status);
        panel.add(Department);
        panel.add(JobCode) ;
        panel.add(SearchDepartment);
        panel.add(SearchStatus);
        panel.add(SearchID);
        panel.add(Search);
        panel.add(Jobs);
        panel.add(pane);



        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // panel.remove(CreateTable(conn, panel, query, 200, 200));
                  panel.remove(pane);
                  panel.repaint();
                String SearchQuery =  "select job.JobID, task.TaskID, task.Department, task.StartTime, task.Instruction, task.Completed, staff.Name from ((job inner join task ON job.JOBID=task.JOBID) inner join staff ON task.StaffID=staff.StaffID) Where job.jobID = '" + SearchID.getText() + "' AND task.department = '" + SearchDepartment.getSelectedItem() +"' AND task.completed = '" + SearchStatus.getSelectedItem() +"'";
                try {
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(SearchQuery);

                    while (rs.next()) {

                        Vector<String> vstring = new Vector<String>();

                        vstring.add(rs.getString("JobID"));
                        vstring.add(rs.getString("TaskID"));
                        vstring.add(rs.getString("Department"));
                        vstring.add(rs.getString("StartTime"));
                        vstring.add(rs.getString("Completed"));
                        vstring.add(rs.getString("Name"));
                        vstring.add(rs.getString("Instruction"));

                        vstring.add("\n\n\n\n\n\n\n");
                        newData.add(vstring);
                    }
                } catch (SQLException a) {
                    a.printStackTrace();
                } JTable jobs = new JTable(newData, coloumns);
                JScrollPane pane = new JScrollPane(jobs);
                pane.setBounds(200,200,550,100);
                panel.add(pane);
            }
        });



        // sets width and height
        //frame.setSize(1400, 600);

        /*JScrollPane pane = new JScrollPane(jobs);
        frame.add(pane);*/

        // uses no layout managers
        //frame.setLayout(m);

        // makes the frame visible
        //frame.setVisible(true);


    }



}


