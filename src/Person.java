import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    private String name;
    private String surName;
    private String dob;
    private int mobileNum;

    Person() {

    }

    public Person(String name, String surName, String dob, int mobileNum) {
        this.name = name;
        this.surName = surName;
        this.dob = dob;
        this.mobileNum = mobileNum;
    }



    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getDOB() {
        return dob;
    }

    public int getMobileNum() {
        return mobileNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setDOB(String dob) {
        this.dob = dob;
    }

    public void setMobileNum(int mobileNum) {
        this.mobileNum = mobileNum;
    }
}
