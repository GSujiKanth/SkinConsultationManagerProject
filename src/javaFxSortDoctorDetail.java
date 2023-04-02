import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class javaFxSortDoctorDetail {
    public static ArrayList<Doctor> doctorList;

    public static void doctorlistDataTransfer(ArrayList<Doctor> doctorList2) {
        doctorList = doctorList2;
    }

    javaFxSortDoctorDetail() {
        // Creating Grid panels: main panel, topPanel, bottomPanel
        JPanel sortTablePanel = new JPanel(new GridLayout(2,1));

        JPanel bottomPanel = new JPanel(new GridBagLayout());

        // creates a constraints object
        GridBagConstraints gbc = new GridBagConstraints();

        // insets for all components
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;


        // Initializing the JTable
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        table.setBounds(30, 40, 200, 300);

        // Column Names
        model.addColumn("Name");
        model.addColumn("Surname");
        model.addColumn("Date of birth");
        model.addColumn("Mobile No.");
        model.addColumn("Licence No.");
        model.addColumn("Specialization");

        ArrayList<Doctor> cloneDocotList = new ArrayList<>(doctorList); // copy doctor list elements to new list
        cloneDocotList.sort(new DoctorSortByName());

        // Row data
        int i = 0;
        for (Doctor value : cloneDocotList) {
            model.insertRow(i,new String[]{value.getName(), value.getSurName(), String.valueOf(value.getDOB()), Long.toString(value.getMobileNum()), Integer.toString(value.getMedicalLicenceNum()), value.getSpecialization()});
            i++;
        }

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        sortTablePanel.add(sp);  // Add scroll pane to mainPanel

        // Back button
        JButton backJbtn = new JButton("Back");
        gbc.gridx = 1;
        gbc.gridy = 0;
        bottomPanel.add(backJbtn,gbc);

        sortTablePanel.add(bottomPanel);


        // frame1
        JFrame sortTable = new JFrame(); // Frame initialization
        sortTable.setTitle("JTable Example"); // Frame Title
        sortTable.setVisible(true); // Frame Visible = true
        sortTable.setSize(500, 200); // Frame Size
        sortTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application

        sortTable.add(sortTablePanel);


        // Back button
        backJbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortTable.setVisible(false);
                new javaFxBookConsultation1();
            }
        });
    }
}
