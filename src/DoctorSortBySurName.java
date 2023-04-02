import java.util.Comparator;

// Helper class implementing Comparator interface
public class DoctorSortBySurName implements Comparator<Doctor> {

    @Override
    public int compare(Doctor doctor1, Doctor doctor2) {
        return doctor1.getSurName().compareTo(doctor2.getSurName());
    }
}
