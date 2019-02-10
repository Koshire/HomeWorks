package lesson9homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class task2 {

    public static void main(String[] args) {

        Student vasya = new Student("Василий", "Иванов", 27, 7);
        Student petya = new Student("Петя", "Петров", 21, 10);
        Student slava = new Student("Слава", "Андреев", 24, 5);
        Student katya = new Student("Катя", "Птичкина", 23, 8);
        Student marfa = new Student("Марфа", "Васильева", 19, 9);
        List<Student> group = new ArrayList<>(Arrays.asList(vasya, petya, slava, katya, marfa));

        System.out.println(getHiRateStudent(group).toString());
        group.sort(new ComparatorFullName().thenComparing(new ComparatorAge()).thenComparing(new ComparatorAverRate()));
        System.out.println(group);
    }

    private static Student getHiRateStudent(List<Student> group) {
        Iterator<Student> iterator = group.iterator();
        Student tempStudent = group.get(0);
        while (iterator.hasNext()) {
            Student currentStudent = iterator.next();
            if (currentStudent.getAverageYearRate()>tempStudent.getAverageYearRate()){
                tempStudent = currentStudent;
            }
        }
        return tempStudent;
    }
}
