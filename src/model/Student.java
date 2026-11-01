package model;

public class Student extends person {

    private String studentNumber;
    private String major;
    private double gpa;

    // Constructor
    public Student(int id, String name, String email,
                   String studentNumber, String major, double gpa) {

        super(id, name, email);

        this.studentNumber = studentNumber;
        this.major = major;
        this.gpa = gpa;
    }

    // Getters
    public String getStudentNumber() {
        return studentNumber;
    }

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }

    // Setters
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() +
                ", Student Number: " + studentNumber +
                ", Major: " + major +
                ", GPA: " + gpa;
    }
    public double calculateGPA() {
        return gpa;
    }
}