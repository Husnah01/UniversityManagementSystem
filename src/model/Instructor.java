package model;

public class Instructor extends person {

    private String employeeNumber;
    private String department;
    private String specialization;

    // Constructor
    public Instructor(int id, String name, String email,
                      String employeeNumber, String department,
                      String specialization) {

        super(id, name, email);

        this.employeeNumber = employeeNumber;
        this.department = department;
        this.specialization = specialization;
    }

    // Getters
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getDepartment() {
        return department;
    }

    public String getSpecialization() {
        return specialization;
    }

    // Setters
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() +
                ", Employee Number: " + employeeNumber +
                ", Department: " + department +
                ", Specialization: " + specialization;
    }
}