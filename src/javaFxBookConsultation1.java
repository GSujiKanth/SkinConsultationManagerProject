// Packages to import
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class javaFxBookConsultation1 extends JFrame {

    public static ArrayList<Doctor> doctorList;

    public static void doctorListDataTransfer(ArrayList<Doctor> doctorList2) {
        doctorList = doctorList2;
    }

    javaFxBookConsultation1()
    {
        //....................................................FRAME 1.........................................................................//
        // Create j panels: main1Panel, bottom1Panel
        JPanel main1Panel = new JPanel(new GridLayout(2,1));
        JPanel bottom1Panel = new JPanel(new GridBagLayout());

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

        // Row data
        int i = 0;
        for (Doctor value : doctorList) {
            model.insertRow(i,new String[]{value.getName(), value.getSurName(), String.valueOf(value.getDOB()), Integer.toString(value.getMobileNum()), Integer.toString(value.getMedicalLicenceNum()), value.getSpecialization()});
            i++;
        }

        // adding table to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        main1Panel.add(sp);  // Add scroll pane to mainPanel


        // Sort table button
        JButton sortTableJbtn = new JButton("Sort Table");
        gbc.gridx = 1;
        gbc.gridy = 0;
        bottom1Panel.add(sortTableJbtn,gbc); // Add sortTableJbtn to bottom1Panel

        // Create Book consultation button
        JButton bookJbtn = new JButton("Book Doctor");
        gbc.gridx = 1;
        gbc.gridy = 1;
        bottom1Panel.add(bookJbtn,gbc); // Add bookJbtn to bottom1Panel

        main1Panel.add(bottom1Panel); // Add bottom1Panel to main1Panel


        // frame1
        JFrame frame1 = new JFrame(); // Frame initialization
        frame1.setTitle("JTable Example"); // Frame Title
        frame1.setVisible(true); // Frame Visible = true
        frame1.setSize(700, 200); // Frame Size
        frame1.setResizable(false); // Not resizable
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application
        frame1.add(main1Panel); // Add main1Panel to the frame


        // bookJbtn button
        bookJbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false); // Frame Visible = false
                new javaFxBookConsultation2();
            }
        });

        // sortTableJbtn button
        sortTableJbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                javaFxSortDoctorDetail.doctorlistDataTransfer(doctorList);
                frame1.setVisible(false); // Frame Visible = false
                new javaFxSortDoctorDetail();
            }
        });
    }
}

