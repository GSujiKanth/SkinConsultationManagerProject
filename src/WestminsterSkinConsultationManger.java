import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WestminsterSkinConsultationManger implements SkinConsultationManager {
    public static ArrayList<Doctor> doctorCentre = new ArrayList<>();

    public static ArrayList<Patient> patientList = new ArrayList<>();

    public static ArrayList<Consultation> consultationList = new ArrayList<>();

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Define a regular expression pattern for a valid phone number
        String regex = "^(?:\\+94|0)?(\\d{9})$";
        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        // Match the input string against the pattern
        Matcher matcher = pattern.matcher(phoneNumber);
        // Return true if the input string matches the pattern, false otherwise
        return matcher.matches();
    }

    public static boolean isMedicalNumberAvailable(int medicalNum) {
        for (Doctor doctor: doctorCentre) {
            if (doctor.getMedicalLicenceNum() == medicalNum) {
                return false;
            }
        }
        return true;
    }


    public static void addToDoctorList(Doctor object) {
        doctorCentre.add(object);
    }

    public static void addToPatientList(Patient object) {
        patientList.add(object);
    }

    public static void addToConsultationList(Consultation object) {
        consultationList.add(object);
    }

    private static boolean check = false;

    public static void main(String[] args) throws IOException {
        // Scanner class
        Scanner input = new Scanner(System.in);

        // User input variables
        String option;
        String name;
        String surName;
        String birthDate;
        int mobileNum;
        int licenceNum;
        String specialize;


        // Read back the saved objects in the File
        try {
            FileInputStream fi = new FileInputStream(new File("DoctorData.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read back saved objects
            System.out.println("Previously saved objects are added to the system again. Now the file is empty.");
            while (true) {
                try {
                    Doctor savedDoctor = (Doctor) oi.readObject();
                    doctorCentre.add(savedDoctor);
                    Doctor.count++;
                } catch (EOFException e) {
                    // End of the stream reached, exit the loop
                    break;
                } catch (ClassNotFoundException g) {
                    // Class of the object could not be found, print the stack trace and continue reading
                    g.printStackTrace();
                }
            }
        } catch (FileNotFoundException f) {
            System.out.println("File not found");
        } catch (IOException f) {
            System.out.println("There is no previously saved objects.\nUse the consloe menu.");
        }

        // Delete the objects saved in the file
        new FileOutputStream("DoctorData.txt").close();

        // Console part
        while (true) {
            //console menu
            System.out.println("""
                \n
                A : Add new doctor
                D : Delete a doctor
                P : Print the list of doctors
                S : Save in a file
                G : GUI (For user)
                X : Exit
                """);

            option = input.next();

            switch (option) {
                case "A":
                    // Add new doctor option
                    if (Doctor.count <= 9) {

                        // Prompt for name
                        System.out.println("Enter Name: ");
                        name = input.next();

                        // Checking that only letters are taken as  name input
                        if (!name.matches("[a-zA-Z]+")) {
                            System.out.println("Name should not contain numbers or special characters.");
                            do {
                                // Prompt for name until proper name given
                                System.out.println("Enter Name: ");
                                name = input.next();
                            } while (!(name.matches("[a-zA-Z]+")));
                        }

                        // Prompt for surname
                        System.out.println("Enter Surname: ");
                        surName = input.next();

                        // Checking that only letters are taken as surname input
                        if (!surName.matches("[a-zA-Z]+")) {
                            System.out.println("Surname should not contain numbers or special characters.");
                            do {
                                // Prompt for name until proper surname given
                                System.out.println("Enter Surname: ");
                                surName = input.next();
                            } while (!(surName.matches("[a-zA-Z]+")));
                        }

                        // Prompt for date of birth
                        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                        Date date;
                        while (true) {
                            try {
                                System.out.println("Enter date of birth(yyyy/mm/dd): ");
                                birthDate = input.next();
                                date = df.parse(birthDate);
                                break;
                            } catch (ParseException e) {
                                System.out.println("Wrong input type.");
                            }
                        }


                        // Prompt for mobile number
                        while (true) {
                            try {
                                System.out.println("Enter mobile number: ");
                                String inputStr = input.next();
                                mobileNum = Integer.parseInt(inputStr);
                                if (isValidPhoneNumber(String.valueOf(mobileNum))) {
                                    break;
                                } else {
                                    System.out.println("Invalid phone number");
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Wrong input type");
                            }
                        }


                        // Prompt for licence number
                        while (true) {
                            try {
                                System.out.println("Enter medical licence number: ");
                                String inputStr = input.next();
                                licenceNum = Integer.parseInt(inputStr);
                                if (isMedicalNumberAvailable(licenceNum)) {
                                    break;
                                } else {
                                    System.out.println("This medical licence number has already taken.");
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Wrong input type");
                            }
                        }

                        // Prompt for specialization
                        System.out.println("Enter specialization: ");
                        specialize = input.next();

                        if (!specialize.matches("[a-zA-Z]+")) {
                            System.out.println("specialization should not contain numbers or special characters.");
                            do {
                                // Prompt for name until proper name given
                                System.out.println("Enter specialization: ");
                                name = input.next();
                            } while (!(name.matches("[a-zA-Z]+")));
                        }


                        // Create object of Doctor class
                        Doctor doctor = new Doctor(name, surName, birthDate, mobileNum, licenceNum, specialize);

                        // Add created Doctor objects to DoctorCentre array list
                        addToDoctorList(doctor);

                    } else {
                        System.out.println("Centre has allocated for 10 doctors. You can't add doctor.");
                    }
                    break;

                case "D":
                    // Delete doctor option
                    if (doctorCentre.isEmpty()) {
                        System.out.println("The system does not contain any doctors");
                    } else {
                        while (true) {
                            try {
                                System.out.println("Enter medical licence number: "); // Prompt for licence number
                                licenceNum = input.nextInt();
                                if (isMedicalNumberAvailable(licenceNum)) {
                                    System.out.println("This medical licence number is not in the system");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Wrong input type");
                            }
                        }

                        Doctor.count--; // Decrese total number of Doctor objects in the Doctor class by one
                        for (Doctor value : doctorCentre) {
                            if (value.getMedicalLicenceNum() == licenceNum) {
                                System.out.println("........Deleted doctor details........");
                                System.out.println(value);
                                System.out.println("Total number of doctors in the centre = " + Doctor.getCount());
                                doctorCentre.remove(value);
                                check = false;
                                break;
                            }
                        }
                    }

                    if (check) {
                        System.out.println("This medical licence No. does not belong to any doctor");
                    }
                    break;

                case "P":
                    // Sorting Doctor elements by surname
                    if (doctorCentre.isEmpty()) {
                        System.out.println("The system does not contain any doctors");

                    } else {
                        System.out.println(".....Doctor List sorted by Surname.....");

                        ArrayList<Doctor> DoctorListClone = new ArrayList<>(doctorCentre); // copy elements to new list

                        DoctorListClone.sort(new DoctorSortBySurName());

                        // Interacting over entries to print them
                        for (Doctor value : DoctorListClone) {
                            System.out.println(value);
                        }
                    }
                    break;

                case "S":
                    // Save objects to File (File Handling)
                    if (doctorCentre.isEmpty()) {
                        System.out.println("The system does not contain any doctors");
                    } else {
                        try {
                            // Using byte stream to saved objects in File
                            FileOutputStream f = new FileOutputStream(new File("DoctorData.txt"), true);
                            ObjectOutputStream o = new ObjectOutputStream(f);

                            // Save objects to file
                            for (Doctor value : doctorCentre) {
                                o.writeObject(value);
                            }

                            o.close(); // Closing ObjectOutputStream
                            f.close(); // Closing FileOutputStream

                        } catch (FileNotFoundException e) {
                            System.out.println("File not found");
                        } catch (IOException e) {
                            System.out.println("Error initializing stream");
                        }
                    }
                    break;

                case "G":

                    // User GUImpart
                    if (doctorCentre.isEmpty()) {
                        System.out.println("The system does not contain any doctors");
                    } else {
                        javaFxBookConsultation1.doctorListDataTransfer(doctorCentre); // Transfer doctor array list data to BookConsultationPage1
                        javaFxBookConsultation4.doctorListDataTransfer(doctorCentre); // Transfer doctor array list data to BookConsultationPage4

                        new Home(); // Open home frame of the User GUI part
                    }
                    break;

                case "X":
                    // Quit console system
                    return;

                default:
                    System.out.println("Invalid input");

            }
        }
    }
}
