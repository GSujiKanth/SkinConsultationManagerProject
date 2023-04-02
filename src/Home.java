import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame{

    Home() {
        // J panels: homePanel
        JPanel homePanel = new JPanel(new GridBagLayout());

        // creates a constraints object
        GridBagConstraints gbc = new GridBagConstraints();

        // insets for all components
        gbc.insets = new Insets(2, 2, 20, 2);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // System name label
        JLabel label = new JLabel("Westminster Skin Consultation");
        gbc.gridx = 1;
        gbc.gridy = 0;
        homePanel.add(label,gbc);

        // Booking button
        JButton bookingBtn = new JButton("Check Doctor List");
        gbc.gridx = 1;
        gbc.gridy = 1;
        homePanel.add(bookingBtn,gbc);

        // patient login button
        JButton PatientLoginBtn = new JButton("Check booked consultations");
        gbc.gridx = 1;
        gbc.gridy = 2;
        homePanel.add(PatientLoginBtn,gbc);


        // homepage frame
        JFrame homepage = new JFrame(); // Frame initialization
        homepage.setTitle("JTable Example"); // Frame Title
        homepage.setVisible(true); // Frame Visible = true
        homepage.setSize(500, 300); // Frame Size
        homepage.setResizable(false); // Not resizable
        homepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application
        homepage.add(homePanel); // Add homePanel to the frame


        // bookingBtn button
        bookingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homepage.setVisible(false);
                new javaFxBookConsultation1();
            }
        });

        // loginBtn button
        PatientLoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (WestminsterSkinConsultationManger.patientList.isEmpty()) {
                    JOptionPane.showMessageDialog(PatientLoginBtn,"The system does not contain any patients");
                } else {
                    homepage.setVisible(false);
                    new javaFxPatientLogin();
                }
            }
        });
    }
}
