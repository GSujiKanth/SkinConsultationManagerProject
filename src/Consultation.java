import java.util.Date;

public class Consultation {
    String date;
    int cost;
    String note;
    int doctorLicenceNum;
    int patientID;

    public Consultation(String date, int cost, String note, int doctorLicenceNum, int patientID) {
        this.date = date;
        this.cost = cost;
        this.note = note;
        this.doctorLicenceNum = doctorLicenceNum;
        this.patientID = patientID;
    }

    public String getDate() {
        return date;
    }

    public int getCost() {
        return cost;
    }

    public String getNote() {
        return note;
    }

    public int getDoctorLicenceNum() {
        return doctorLicenceNum;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
