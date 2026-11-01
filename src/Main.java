import model.*;

public class Main {

    public static void main(String[] args) {

        // Create an undergraduate student
        double[] grades = {3.5, 4.0, 3.0};
        int[] credits = {3, 3, 2};

        UndergraduateStudent undergraduate =
                new UndergraduateStudent(
                        1, "Alice Smith", "alice@gmail.com",
                        "UG001", "Computer Science", 3.5,
                        grades, credits
                );

        // Create a graduate student
        GraduateStudent graduate =
                new GraduateStudent(
                        2, "Bob Jones", "bob@gmail.com",
                        "GR001", "Data Science", 3.8,
                        3.7, 4.0
                );

        // Display GPA
        System.out.println("Undergraduate Student GPA: "
                + undergraduate.calculateGPA());

        System.out.println("Graduate Student GPA: "
                + graduate.calculateGPA());
    }
}
