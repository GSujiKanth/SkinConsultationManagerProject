import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import static javax.swing.JOptionPane.showMessageDialog;

public class javaFxBookConsultation3 {

    private static int docMedNo;

    private static String docfullName;

    public static void docMedLicNoTransfer(int number) {
        docMedNo =  number;
    }

    javaFxBookConsultation3() {
        //....................................................FRAME 3.........................................................................//
        // Creating j panels: main3Panel
        JPanel main3Panel = new JPanel(new GridBagLayout());

        // creates a constraints object
        GridBagConstraints gbc = new GridBagConstraints();

        // insets for all components
        gbc.insets = new Insets(5, 50, 5, 50);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Doctor medical id
        JLabel docIdInfoLbl = new JLabel("Medical licence No.");
        gbc.gridx = 0;
        gbc.gridy = 0;
        main3Panel.add(docIdInfoLbl,gbc);

        JLabel docIdLbl = new JLabel(String.valueOf(docMedNo));
        gbc.gridx = 1;
        gbc.gridy = 0;
        main3Panel.add(docIdLbl,gbc);

        // Doctor full name
        JLabel docNameInfoLbl = new JLabel("Doctor Name");
        gbc.gridx = 0;
        gbc.gridy = 1;
        main3Panel.add(docNameInfoLbl,gbc);

        // Doctor full name assigning
        for (Doctor value: javaFxBookConsultation1.doctorList) {
            if (value.getMedicalLicenceNum() == docMedNo) {
                docfullName = value.getName()+" "+value.getSurName();
            }
        }

        JLabel docNameLbl = new JLabel(docfullName);
        gbc.gridx = 1;
        gbc.gridy = 1;
        main3Panel.add(docNameLbl,gbc);

        // Patient name
        JLabel patNameLbl = new JLabel("Patient Name");
        gbc.gridx = 0;
        gbc.gridy = 2;
        main3Panel.add(patNameLbl,gbc);

        JTextField patNameJtf = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        patNameJtf.setMinimumSize(patNameJtf.getPreferredSize());
        main3Panel.add(patNameJtf,gbc);

        // Patient surname
        JLabel patSurNameLbl = new JLabel("Patient surname");
        gbc.gridx = 0;
        gbc.gridy = 3;
        main3Panel.add(patSurNameLbl,gbc);

        JTextField patSurNameJtf = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1;
        patSurNameJtf.setMinimumSize(patSurNameJtf.getPreferredSize());
        main3Panel.add(patSurNameJtf,gbc);

        // Patient date of birth
        JLabel patDobLbl = new JLabel("Patient Date of Birth");
        gbc.gridx = 0;
        gbc.gridy = 4;
        main3Panel.add(patDobLbl,gbc);

        JTextField patDobJtf = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1;
        patDobJtf.setMinimumSize(patDobJtf.getPreferredSize());
        main3Panel.add(patDobJtf,gbc);

        // Patient mobile number
        JLabel patMobNoLbl = new JLabel("Patient Mobile No.");
        gbc.gridx = 0;
        gbc.gridy = 5;
        main3Panel.add(patMobNoLbl,gbc);

        JTextField patMobNoJtf = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1;
        patMobNoJtf.setMinimumSize(patMobNoJtf.getPreferredSize());
        main3Panel.add(patMobNoJtf,gbc);

        // Patient ID
        JLabel patIdLbl = new JLabel("Patient ID");
        gbc.gridx = 0;
        gbc.gridy = 6;
        main3Panel.add(patIdLbl,gbc);

        JTextField patIdJtf = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 1;
        patIdJtf.setMinimumSize(patIdJtf.getPreferredSize());
        main3Panel.add(patIdJtf,gbc);

        // Consultation hour
        JLabel conHourLbl = new JLabel("Consultation Hour");
        gbc.gridx = 0;
        gbc.gridy = 7;
        main3Panel.add(conHourLbl,gbc);

        JTextField conHourJtf = new JTextField(5);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weightx = 1;
        conHourJtf.setMinimumSize(conHourJtf.getPreferredSize());
        main3Panel.add(conHourJtf,gbc);

        // Consultation date
        JLabel conDateLbl = new JLabel("Consultation Date");
        gbc.gridx = 0;
        gbc.gridy = 8;
        main3Panel.add(conDateLbl,gbc);

        JTextField conDateJtf = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.weightx = 1;
        conDateJtf.setMinimumSize(conDateJtf.getPreferredSize());
        main3Panel.add(conDateJtf,gbc);

        //Consultation time
        JLabel conTimeLbl = new JLabel("Consultation time");
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.weightx = 1;

        // Consultation Note
        JLabel conNoteLbl = new JLabel("Consultation Note");
        gbc.gridx = 0;
        gbc.gridy = 9;
        main3Panel.add(conNoteLbl,gbc);

        JTextField conNoteJtf = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.weightx = 1;
        conNoteJtf.setMinimumSize(conNoteJtf.getPreferredSize());
        main3Panel.add(conNoteJtf,gbc);

        // Patient password
        JLabel patPasswordLbl = new JLabel("Password");
        gbc.gridx = 0;
        gbc.gridy = 10;
        main3Panel.add(patPasswordLbl,gbc);

        JTextField patPasswordJtf = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.weightx = 1;
        patPasswordJtf.setMinimumSize(patPasswordJtf.getPreferredSize());
        main3Panel.add(patPasswordJtf,gbc);

        // Create Save button
        JButton saveJbtn= new JButton("BOOK CONSULTATION");
        gbc.gridx = 1;
        gbc.gridy = 11;
        main3Panel.add(saveJbtn,gbc);


        // Frame3
        JFrame frame3 = new JFrame(); // Frame initialization
        frame3.setTitle("JTable Example"); // Frame Title
        frame3.setVisible(true); // Frame Visible = true
        frame3.setResizable(false); // Not resizable
        frame3.setSize(700, 700); // Frame Size
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application
        frame3.add(main3Panel); // Add main3Panel to the frame


        // saveJbtn button
        saveJbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patName; // patient name variable
                String patSurName; // patient sur name variable
                String patDob; // patient date of birth
                String conNote; // Consultation note
                String conDate; // Consultation date
                int patMobNo; // Patient mobile number
                int patId; // Patient ID
                int conHour; // Consultation hour
                String patPassword; // Create patient password variable

                if (patNameJtf.getText().equals("")) {
                    showMessageDialog(patNameJtf,"Enter patient name");

                }else if (patSurNameJtf.getText().equals("")) {
                    showMessageDialog(patSurNameJtf,"Enter patient surname");

                } else if (patDobJtf.getText().equals("")) {
                    showMessageDialog(patDobJtf,"Enter patient's date of birth(yyyy/mm/dd)");

                } else if (patMobNoJtf.getText().equals("")) {
                    showMessageDialog(patMobNoJtf, "Enter patient mobile No.");

                } else if (patIdJtf.getText().equals("")) {
                    showMessageDialog(patIdJtf, "Enter patient ID");

                } else if (conHourJtf.getText().equals("")) {
                    showMessageDialog(conHourJtf, "Enter consultation hours");

                }else if (conDateJtf.getText().equals("")) {
                    showMessageDialog(conDateJtf,"Enter consultation date(yyyy/mm/dd)");

                } else if (conNoteJtf.getText().equals("")) {
                    showMessageDialog(conNoteJtf,"Enter note");

                } else if (patPasswordJtf.getText().equals("")) {
                    showMessageDialog(conNoteJtf,"Enter password");
                } else {
                    patName = patNameJtf.getText();
                    patSurName = patSurNameJtf.getText();
                    patPassword = patPasswordJtf.getText();

                    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                    Date date;

                    patDob = patDobJtf.getText(); // Create
                    try {
                        date = df.parse(patDob);
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(patDobJtf,"Wrong input type. Enter yyyy/MM/dd");
                    }

                    // Note encryption --------------------------------------------------------------/
                    conNote = conNoteJtf.getText();
                    String encodedconNote = Base64.getEncoder().encodeToString(conNote.getBytes());
                    // ------------------------------------------------------------------------------/

                    conDate = conDateJtf.getText();
                    try {
                        date = df.parse(conDate);
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(conDateJtf,"Wrong input type. Enter yyyy/MM/dd");
                    }

                    try {
                        patMobNo = Integer.parseInt(patMobNoJtf.getText());
                        patId = Integer.parseInt(patIdJtf.getText());
                        conHour = Integer.parseInt(conHourJtf.getText());

                        javaFxBookConsultation4.patientDataTransfer(patName,patSurName,patDob,patMobNo,patId,patPassword);
                        javaFxBookConsultation4.consultationDataTransfer(conHour,conDate,encodedconNote);
                        javaFxBookConsultation4.doctorDataTransfer(docMedNo,docfullName);

                        frame3.setVisible(false);
                        new javaFxBookConsultation4();

                    } catch (NumberFormatException ex) {
                        showMessageDialog(patMobNoJtf,"Wrong input type");
                    }
                }
            }
        });
    }
}
