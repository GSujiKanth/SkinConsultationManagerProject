import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class javaFxBookConsultation4 {
    // Patient data variables
    private static String patName;
    private static String patSurName;
    private static String patDob;
    private static int patMobNo;
    private static int patId;
    private static String patPassword;

    // Consultation data variables
    private static int conHour;
    private static String conDate;
    private static String conNote;
    private static int conCost;

    // Doctor data variables
    private static int docLicNum;
    private static String docFullName;

    public static ArrayList<Doctor> doctorList; // Arraylist of Doctor objects

    String message; // Booking confirmation message

    public static void doctorListDataTransfer(ArrayList<Doctor> doctorList2) {
        doctorList = doctorList2;
    }

    public static void patientDataTransfer(String patientName, String patientSurName, String patientDob, int patientMobNo, int patientId, String patientPass) {
        patName = patientName;
        patSurName = patientSurName;
        patDob = patientDob;
        patMobNo = patientMobNo;
        patId = patientId;
        patPassword = patientPass;
    }

    public static void consultationDataTransfer(int consultationHour, String consultationDate, String consultationNote) {
        conHour = consultationHour;
        conDate = consultationDate;
        conNote = consultationNote;
    }

    public static void doctorDataTransfer(int doctorLicNum, String doctorFullName) {
        docLicNum = doctorLicNum;
        docFullName = doctorFullName;
    }

    // Check doctor availability
    private boolean checkDoctorAvailability(int doctorLicenceNum, String consultationDate) {
        for (Consultation value : WestminsterSkinConsultationManger.consultationList) {
            if (value.getDoctorLicenceNum() == doctorLicenceNum && value.getDate().equals(consultationDate)) {
                return false;
            }
        }
        return true;
    }

    javaFxBookConsultation4() {
        Patient patient = new Patient(patName, patSurName, patDob, patMobNo, patId, patPassword);  // Create patient object

        WestminsterSkinConsultationManger.addToPatientList(patient); // Add patient object to patientList

        // Calculate consultation fee
        for (Patient value : WestminsterSkinConsultationManger.patientList) {
            if (value.getPatientId() == patId) {
                conCost = 25 * conHour;
            } else {
                conCost = 15 + (conHour - 1) * 25;
            }
        }

         //Check doctor availability
        boolean available = checkDoctorAvailability(docLicNum, conDate);

        if (available) {
            message = "Consultation is booked";
            Consultation consultation = new Consultation(conDate, conCost, conNote, docLicNum, patId);  // Add consultation object to array list
            WestminsterSkinConsultationManger.addToConsultationList(consultation);
        } else {
            message = "The doctor you have chosen not available on that day.\nTherefore another doctor is allocated";
            int randomMedLicNo;
            String randomDoctorFullName;
            do {
                int randomIndex = (int) (Math.random() * doctorList.size());
                Doctor randomDoctor = doctorList.get(randomIndex);
                randomDoctorFullName = randomDoctor.getName()+" "+randomDoctor.getSurName();
                randomMedLicNo = randomDoctor.getMedicalLicenceNum();
                available = checkDoctorAvailability(randomMedLicNo, conDate);
            } while (!available);

            // Doctor full name assigning
            docLicNum = randomMedLicNo;
            // Doctor medical licence number assigning
            docFullName = randomDoctorFullName;

            Consultation consultation = new Consultation(conDate, conCost, conNote, docLicNum, patId);  // Add consultation object to array list
            WestminsterSkinConsultationManger.addToConsultationList(consultation);
        }


        //....................................................FRAME 4.........................................................................//
        // Creating j panels: main4Panel
        JPanel main4Panel = new JPanel(new GridBagLayout());

        // creates a constraints object
        GridBagConstraints gbc = new GridBagConstraints();

        // insets for all components
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Confirmation message label
        JLabel confirmation = new JLabel(message);
        gbc.gridx = 1;
        gbc.gridy = 0;
        confirmation.setSize(300,100);
        main4Panel.add(confirmation,gbc);

        // Doctor full name label
        JLabel docNameInfo = new JLabel("Doctor Name");
        gbc.gridx = 0;
        gbc.gridy = 1;
        main4Panel.add(docNameInfo,gbc);

        JLabel docNameLbl = new JLabel(docFullName);
        gbc.gridx = 1;
        gbc.gridy = 1;
        main4Panel.add(docNameLbl,gbc);

        // Patient full name label
        JLabel patNameInfo = new JLabel("Patient Name");
        gbc.gridx = 0;
        gbc.gridy = 2;
        main4Panel.add(patNameInfo,gbc);

        JLabel patNameLbl = new JLabel(patName+" "+patSurName);
        gbc.gridx = 1;
        gbc.gridy = 2;
        main4Panel.add(patNameLbl,gbc);

        // Consultation fee label
        JLabel amountInfo = new JLabel("Consultation Fee");
        gbc.gridx = 0;
        gbc.gridy = 3;
        main4Panel.add(amountInfo,gbc);

        JLabel amountLbl = new JLabel(String.valueOf(conCost));
        gbc.gridx = 1;
        gbc.gridy = 3;
        main4Panel.add(amountLbl,gbc);

        // Home button to redirect home window
        JButton homeJbtn = new JButton("Home");
        gbc.gridx = 1;
        gbc.gridy = 4;
        main4Panel.add(homeJbtn,gbc);

        // Close button
        JButton closeJbtn = new JButton("CLOSE");
        gbc.gridx = 1;
        gbc.gridy = 5;
        main4Panel.add(closeJbtn,gbc);


        // Frame4
        JFrame frame4 = new JFrame(); // frame4 initialization
        frame4.setTitle("JTable Example"); // frame4 Title
        frame4.setVisible(true); // frame4 Visible = true
        frame4.setSize(700, 400); // frame4 Size
        frame4.setResizable(false); // frame 4 not resizable
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application
        frame4.add(main4Panel); // Add main4Panel into frame4


        // homeJbtn.button
        homeJbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame4.setVisible(false);
                new Home();
            }
        });
        
        // closeJbtn button
        closeJbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame4.setVisible(false);
            }
        });
    }

}
