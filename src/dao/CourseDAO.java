
package dao;

import database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAO {

    // CREATE: Add a course
    public boolean addCourse(String courseCode, String courseName, int credits) {

        String sql = "INSERT INTO courses (course_code, course_name, credits) "
                + "VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, courseCode);
            statement.setString(2, courseName);
            statement.setInt(3, credits);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error adding course: " + e.getMessage());
            return false;
        }
    }

    // READ: Display all courses
    public void getAllCourses() {

        String sql = "SELECT * FROM courses";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println(
                        "ID: " + resultSet.getInt("course_id")
                                + ", Code: " + resultSet.getString("course_code")
                                + ", Name: " + resultSet.getString("course_name")
                                + ", Credits: " + resultSet.getInt("credits")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving courses: " + e.getMessage());
        }
    }

    // UPDATE: Update course details
    public boolean updateCourse(int courseId, String courseCode,
                                String courseName, int credits) {

        String sql = "UPDATE courses SET course_code = ?, "
                + "course_name = ?, credits = ? "
                + "WHERE course_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, courseCode);
            statement.setString(2, courseName);
            statement.setInt(3, credits);
            statement.setInt(4, courseId);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating course: " + e.getMessage());
            return false;
        }
    }

    // DELETE: Delete a course
    public boolean deleteCourse(int courseId) {

        String sql = "DELETE FROM courses WHERE course_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, courseId);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting course: " + e.getMessage());
            return false;
        }
    }

}
