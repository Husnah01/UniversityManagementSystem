import model.*;
import management.UniversityManager;

public class Main {

    public static void main(String[] args) {

        // Create University Manager
        UniversityManager manager = new UniversityManager();

        // Create students
        Student student1 = new Student(
                1, "Alice Smith", "alice@gmail.com",
                "ST001", "Computer Science", 3.8
        );

        Student student2 = new Student(
                2, "Bob Jones", "bob@gmail.com",
                "ST002", "Information Technology", 3.5
        );

        // Create a course
        Course course1 = new Course(
                101, "Java Programming", "JAVA101", 3
        );

        // Create an instructor
        Instructor instructor1 = new Instructor(
                1, "Mr. John", "john@gmail.com",
                "INS001", "Computing", "Java Programming"
        );

        // Add students to List
        manager.addStudent(student1);
        manager.addStudent(student2);

        // Add course to Set
        manager.addCourse(course1);
        Course duplicateCourse = new Course(
                101, "Advanced Java", "JAVA202", 4
        );

        manager.addCourse(duplicateCourse);

        // Assign instructor using Map
        manager.assignInstructor(course1, instructor1);

        // Display information
        System.out.println("===== STUDENTS =====");
        manager.displayStudents();

        System.out.println("\n===== COURSES =====");
        manager.displayCourses();

        System.out.println("\n===== INSTRUCTOR ASSIGNMENTS =====");
        manager.displayInstructorAssignments();
    }
}