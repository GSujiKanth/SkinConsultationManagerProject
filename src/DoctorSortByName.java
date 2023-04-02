import java.util.Comparator;

public class DoctorSortByName implements Comparator<Doctor> {
    @Override
    public int compare(Doctor doctor1, Doctor doctor2) {
        return doctor1.getName().compareTo(doctor2.getSurName());
    }
}
