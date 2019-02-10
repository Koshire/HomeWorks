package lesson9homework;

import java.util.Comparator;

public class ComparatorAverRate implements Comparator<Student> {


    @Override
    public int compare(Student student, Student t1) {
        return student.getAverageYearRate() - t1.getAverageYearRate();
    }
}
