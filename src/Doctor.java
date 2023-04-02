import java.io.Serializable;
import java.util.Date;

public class Doctor extends Person implements Serializable {
    int medicalLicenceNum;
    String specialization;
    static int count = 0;

    public Doctor(String name, String surName, String dob, int mobileNum, int medicalLicenceNum, String specialization) {
        super(name, surName, dob, mobileNum);
        this.medicalLicenceNum = medicalLicenceNum;
        this.specialization = specialization;

        count++;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name= " + getName() +
                ", surname= " + getSurName() +
                ", date of birth= " + getDOB() +
                ", mobile num="+ getMobileNum() +
                ", medical licence num="+ getMedicalLicenceNum() +
                ", specilization=" + getSpecialization() +
                '}';
    }

    public int getMedicalLicenceNum() {
        return medicalLicenceNum;
    }

    public String getSpecialization() {
        return specialization;
    }

    public static int getCount() {
        return count;
    }

    public void setMedicalLicenceNum(int medicalLicenceNum) {
        this.medicalLicenceNum = medicalLicenceNum;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

}
