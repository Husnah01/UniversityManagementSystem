package management;

import model.Student;
import model.Course;
import model.Instructor;

import java.util.*;

public class UniversityManager {

    // List of students
    private List<Student> students = new ArrayList<>();

    // Set of courses
    private Set<Course> courses = new HashSet<>();

    // Map of instructor assignments
    private Map<Course, Instructor> instructorAssignments =
            new HashMap<>();

    // Add student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Add course
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Assign instructor
    public void assignInstructor(Course course, Instructor instructor) {
        instructorAssignments.put(course, instructor);
    }

    // Display students
    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Display courses
    public void displayCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    // Display instructor assignments
    public void displayInstructorAssignments() {
        for (Map.Entry<Course, Instructor> entry :
                instructorAssignments.entrySet()) {

            System.out.println(
                    entry.getKey().getCourseName()
                            + " is taught by "
                            + entry.getValue().getName()
            );
        }
    }
}