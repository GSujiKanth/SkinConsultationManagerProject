import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class javaFxPatientDetail {

    private static int patientId;

    private String patientName;

    public static void patientIdDataTransfer(int patId) {
        patientId = patId;
    }

    public javaFxPatientDetail() {
        // Create j panels: consultationDetailPanel, bottomPanel
        JPanel consultationDetailPanel = new JPanel(new GridLayout(2,1));
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
        model.addColumn("Doctor medical licence number");
        model.addColumn("Patient Name");
        model.addColumn("Consultation date");
        model.addColumn("Consultation cost");
        model.addColumn("Consultation note");


        // Row data
        for (Patient value1 : WestminsterSkinConsultationManger.patientList) {
            if (value1.getPatientId() == patientId) {
                patientName = value1.getName()+" "+value1.getSurName();
            }
        }

        for (Consultation value : WestminsterSkinConsultationManger.consultationList) {
            if (value.getPatientID() == patientId) {
                int i = 0;
                // Decode the encoded Note------------------------------------/
                String encodedNote = value.getNote();
                byte[] decodedBytes = Base64.getDecoder().decode(encodedNote);
                String decodedNote= new String(decodedBytes, StandardCharsets.UTF_8);
                // -----------------------------------------------------------/
                model.insertRow(i,new String[]{String.valueOf(value.getDoctorLicenceNum()), patientName, value.getDate(), String.valueOf(value.getCost()), decodedNote});
                ++i;
            }
        }

        // adding table to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        consultationDetailPanel.add(sp);  // Add scroll pane to mainPanel

        // Create Book consultation button
        JButton homeJbtn = new JButton("Home");
        gbc.gridx = 1;
        gbc.gridy = 1;
        bottomPanel.add(homeJbtn,gbc);

        consultationDetailPanel.add(bottomPanel); // Add bottomPanel inside consultationDetailPanel


        // ConDetailFrame
        JFrame ConDetailFrame = new JFrame(); // Frame initialization
        ConDetailFrame.setTitle("JTable Example"); // Frame Title
        ConDetailFrame.setVisible(true); // Frame Visible = true
        ConDetailFrame.setSize(700, 200); // Frame Size
        ConDetailFrame.setResizable(false); // Not resizable
        ConDetailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application
        ConDetailFrame.add(consultationDetailPanel); // Add ConDetailFrame to the frame


        // homeJbtn button
        homeJbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConDetailFrame.setVisible(false); // Frame Visible = false
                new Home();
            }
        });
    }
}
