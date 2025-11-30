//4
public class Student {
    private String lastName;
    private String firstName;
    private int school;
    private int score;

    public Student(String lastName, String firstName, int school, int score) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.school = school;
        this.score = score;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + school + " " + score;
    }
}