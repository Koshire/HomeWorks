package lesson9homework;

public class Student {
    private String firstName;
    private String lastName;
    private int studentAge;
    private int averageYearRate;

    public Student(String firstName, String lastName, int studentAge, int averageYearRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentAge = studentAge;
        this.averageYearRate = averageYearRate;
    }

    public String getFullName() {
        return firstName + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public int getAverageYearRate() {
        return averageYearRate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentAge=" + studentAge +
                ", averageYearRate=" + averageYearRate +
                '}';
    }
}
