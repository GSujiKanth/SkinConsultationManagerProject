import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class javaFxPatientLogin {

    javaFxPatientLogin() {
        // Create j panels: patientLoginPanel
        JPanel patientLoginPanel = new JPanel(new GridBagLayout());

        // creates a constraints object
        GridBagConstraints gbc = new GridBagConstraints();

        // insets for all components
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // patient id
        JLabel patientIdinfo = new JLabel("Patient ID");
        gbc.gridx = 0;
        gbc.gridy = 1;
        patientLoginPanel.add(patientIdinfo,gbc);

        JTextField patientIdJtf = new JTextField(5);
        gbc.gridx = 1;
        gbc.gridy = 1;
        patientIdJtf.setMinimumSize(patientIdJtf.getPreferredSize());
        patientLoginPanel.add(patientIdJtf,gbc);

        // Patient password
        JLabel patientPassinfo = new JLabel("Password");
        gbc.gridx = 0;
        gbc.gridy = 2;
        patientLoginPanel.add(patientPassinfo,gbc);

        JTextField patientPassJtf = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        patientPassJtf.setMinimumSize(patientPassJtf.getPreferredSize());
        patientLoginPanel.add(patientPassJtf,gbc);

        // Show patient consultation information button
        JButton showJbtn = new JButton("Show");
        gbc.gridx = 1;
        gbc.gridy = 3;
        patientLoginPanel.add(showJbtn,gbc);

        // patientLogin frame
        JFrame patientLogin = new JFrame(); // Frame initialization
        patientLogin.setTitle("JTable Example"); // Frame Title
        patientLogin.setVisible(true); // Frame Visible = true
        patientLogin.setSize(500, 200); // Frame Size
        patientLogin.setResizable(false); // Not resizable
        patientLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application
        patientLogin.add(patientLoginPanel); // Add patientLogin to the frame


        // showJbtn button
        showJbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = true;
                if (patientIdJtf.getText().equals("")) {
                    showMessageDialog(patientIdJtf, "Enter patient ID");
                } else if (patientPassJtf.getText().equals("")) {
                    showMessageDialog(patientPassJtf,"Enter password");
                } else {
                    try {
                        int patId = Integer.parseInt(patientIdJtf.getText()); // Create patient id variable
                        String patPassword = patientPassJtf.getText(); // Create patient password variable
                        javaFxPatientDetail.patientIdDataTransfer(patId); // Transfer patient id data to PatientConsultationDetails class
                        for (Patient value : WestminsterSkinConsultationManger.patientList) {
                            if (value.getPatientId() == patId && value.getPassword().equals(patPassword)) {
                                patientLogin.setVisible(false);
                                new javaFxPatientDetail();
                                check = false;
                            }
                        }
                        if (check) {
                            JOptionPane.showMessageDialog(showJbtn,"Patient ID or Password is incorrect");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(patientIdJtf,"Wrong input type");
                    }
                }
            }
        });
    }
}
