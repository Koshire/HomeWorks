package lesson9homework;

public class ComparatorFullName implements java.util.Comparator<Student> {

    @Override
    public int compare(Student student, Student t1) {
        return student.getFullName().compareTo(t1.getFullName());
    }
}
