import java.util.Date;

public class Patient extends Person{
    int patientId;

    String password;

    public Patient(String name, String surName, String dob, int mobileNum, int patientId, String password) {
        super(name, surName, dob, mobileNum);
        this.patientId = patientId;
        this.password = password;
    }



    public int getPatientId() {
        return patientId;
    }

    public String getPassword() {
        return password;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
