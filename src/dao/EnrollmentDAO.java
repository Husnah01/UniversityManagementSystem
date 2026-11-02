
package dao;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.math.BigDecimal;

public class EnrollmentDAO {

    // CREATE: Enroll a student in a course
    public boolean enrollStudent(int studentId, int courseId) {

        String sql = "INSERT INTO enrollments "
                + "(student_id, course_id, enrollment_date) "
                + "VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.setDate(3, Date.valueOf(LocalDate.now()));

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error enrolling student: " + e.getMessage());
            return false;
        }
    }

    // READ: Display all enrollments with student and course details
    public void getAllEnrollments() {

        String sql = "SELECT e.enrollment_id, s.full_name, "
                + "c.course_name, e.enrollment_date, e.grade "
                + "FROM enrollments e "
                + "JOIN students s ON e.student_id = s.student_id "
                + "JOIN courses c ON e.course_id = c.course_id";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println(
                        "Enrollment ID: " + resultSet.getInt("enrollment_id")
                                + ", Student: " + resultSet.getString("full_name")
                                + ", Course: " + resultSet.getString("course_name")
                                + ", Date: " + resultSet.getDate("enrollment_date")
                                + ", Grade: " + resultSet.getBigDecimal("grade")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving enrollments: " + e.getMessage());
        }
    }

    // UPDATE: Update an enrollment
    public boolean updateEnrollment(int enrollmentId, int studentId,
                                    int courseId, LocalDate enrollmentDate,
                                    BigDecimal grade) {

        String sql = "UPDATE enrollments SET student_id = ?, "
                + "course_id = ?, enrollment_date = ?, grade = ? "
                + "WHERE enrollment_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.setDate(3, Date.valueOf(enrollmentDate));
            statement.setBigDecimal(4, grade);
            statement.setInt(5, enrollmentId);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating enrollment: " + e.getMessage());
            return false;
        }
    }

    // DELETE: Delete an enrollment
    public boolean deleteEnrollment(int enrollmentId) {

        String sql = "DELETE FROM enrollments WHERE enrollment_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, enrollmentId);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting enrollment: " + e.getMessage());
            return false;
        }
    }

}
