
import dao.StudentDAO;
import dao.CourseDAO;
import dao.EnrollmentDAO;
import model.Student;

import java.util.Scanner;

public class Main {
    // Safely read an integer
    private static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a whole number.");
            }
        }
    }

    // Safely read a decimal number
    private static double readDouble(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);

            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

        int choice;

        do {
            System.out.println("\n===== UNIVERSITY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Add Course");
            System.out.println("6. View Courses");
            System.out.println("7. Update Course");
            System.out.println("8. Delete Course");
            System.out.println("9. Enroll Student");
            System.out.println("10. View Enrollments");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Student number: ");
                    String number = scanner.nextLine();

                    System.out.print("Full name: ");
                    String name = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Major: ");
                    String major = scanner.nextLine();

                    System.out.print("GPA: ");
                    double gpa = Double.parseDouble(scanner.nextLine());

                    Student student = new Student(
                            0, name, email, number, major, gpa
                    );

                    System.out.println(studentDAO.addStudent(student)
                            ? "Student added successfully!"
                            : "Failed to add student.");
                    break;

                case 2:
                    studentDAO.getAllStudents().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Student ID: ");
                    int studentId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Student number: ");
                    String newNumber = scanner.nextLine();

                    System.out.print("Full name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Email: ");
                    String newEmail = scanner.nextLine();

                    System.out.print("Major: ");
                    String newMajor = scanner.nextLine();

                    System.out.print("GPA: ");
                    double newGpa = Double.parseDouble(scanner.nextLine());

                    Student updatedStudent = new Student(
                            studentId, newName, newEmail,
                            newNumber, newMajor, newGpa
                    );

                    System.out.println(studentDAO.updateStudent(
                            studentId, updatedStudent)
                            ? "Student updated!"
                            : "Update failed.");
                    break;

                case 4:
                    System.out.print("Student ID to delete: ");
                    int deleteStudentId =
                            Integer.parseInt(scanner.nextLine());

                    System.out.println(studentDAO.deleteStudent(deleteStudentId)
                            ? "Student deleted!"
                            : "Deletion failed.");
                    break;

                case 5:
                    System.out.print("Course code: ");
                    String code = scanner.nextLine();

                    System.out.print("Course name: ");
                    String courseName = scanner.nextLine();

                    System.out.print("Credits: ");
                    int credits = Integer.parseInt(scanner.nextLine());

                    System.out.println(courseDAO.addCourse(
                            code, courseName, credits)
                            ? "Course added!"
                            : "Course creation failed.");
                    break;

                case 6:
                    courseDAO.getAllCourses();
                    break;

                case 7:
                    System.out.print("Course ID: ");
                    int courseId = Integer.parseInt(scanner.nextLine());

                    System.out.print("New course code: ");
                    String newCode = scanner.nextLine();

                    System.out.print("New course name: ");
                    String newCourseName = scanner.nextLine();

                    System.out.print("New credits: ");
                    int newCredits = Integer.parseInt(scanner.nextLine());

                    System.out.println(courseDAO.updateCourse(
                            courseId, newCode, newCourseName, newCredits)
                            ? "Course updated!"
                            : "Update failed.");
                    break;

                case 8:
                    System.out.print("Course ID to delete: ");
                    int deleteCourseId =
                            Integer.parseInt(scanner.nextLine());

                    System.out.println(courseDAO.deleteCourse(deleteCourseId)
                            ? "Course deleted!"
                            : "Deletion failed.");
                    break;

                case 9:
                    System.out.print("Student ID: ");
                    int enrollStudentId =
                            Integer.parseInt(scanner.nextLine());

                    System.out.print("Course ID: ");
                    int enrollCourseId =
                            Integer.parseInt(scanner.nextLine());

                    System.out.println(enrollmentDAO.enrollStudent(
                            enrollStudentId, enrollCourseId)
                            ? "Enrollment successful!"
                            : "Enrollment failed.");
                    break;

                case 10:
                    enrollmentDAO.getAllEnrollments();
                    break;

                case 0:
                    System.out.println("Exiting University Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
