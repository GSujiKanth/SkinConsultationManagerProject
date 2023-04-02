import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class javaFxBookConsultation2 {

    javaFxBookConsultation2() {
        //....................................................FRAME 2.........................................................................//
        // Create j panels: main2Panel
        JPanel main2Panel = new JPanel(new GridBagLayout());

        // creates a constraints object
        GridBagConstraints gbc = new GridBagConstraints();

        // insets for all components
        gbc.insets = new Insets(5, 50, 5, 50);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Doctor medical licence number
        JLabel medNoLbl = new JLabel("Medical licence number");
        gbc.gridx = 0;
        gbc.gridy = 0;
        main2Panel.add(medNoLbl,gbc);

        JTextField medNoJtf = new JTextField(5);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        main2Panel.add(medNoJtf,gbc);

        // Create book button
        JButton bookJbtn = new JButton("BOOK");
        gbc.gridx = 1;
        gbc.gridy = 1;
        main2Panel.add(bookJbtn,gbc);


        // Frame2
        JFrame frame2 = new JFrame(); // Frame initialization
        frame2.setTitle("JTable Example"); // Frame Title
        frame2.setVisible(true); // Frame Visible = true
        frame2.setSize(500, 200); // Frame Size
        frame2.setResizable(false); // Not resizable
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application
        frame2.add(main2Panel); // Add main2Panel to the frame


        // checkJbtn button
        bookJbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = true;
                if (medNoJtf.getText().equals("")) {
                    showMessageDialog(medNoJtf, "Enter patient ID");
                } else {
                    try {
                        int MedNo = Integer.parseInt(medNoJtf.getText()); // Create medical licence number variable
                        javaFxBookConsultation3.docMedLicNoTransfer(MedNo); // Transfer medical licence number data to BookConsultationPage3 class

                        for (Doctor value : WestminsterSkinConsultationManger.doctorCentre) {
                            if (value.getMedicalLicenceNum() == MedNo) {
                                frame2.setVisible(false); // frame2 Visible = false
                                new javaFxBookConsultation3();
                                check = false;
                            }
                        }
                        if (check) {
                            JOptionPane.showMessageDialog(bookJbtn,"This medical licence No. does not belong to any doctor");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(medNoJtf,"Wrong input type");
                    }
                }
            }
        });
    }
}
