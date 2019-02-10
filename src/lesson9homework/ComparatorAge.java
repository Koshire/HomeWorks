package lesson9homework;

import java.util.Comparator;

public class ComparatorAge implements Comparator<Student> {

    @Override
    public int compare(Student student, Student t1) {
        return student.getStudentAge() - t1.getStudentAge();
    }
}
