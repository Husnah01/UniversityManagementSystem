package model;

public class GraduateStudent extends Student {

    private double courseworkGPA;
    private double researchGPA;

    // Constructor
    public GraduateStudent(int id, String name, String email,
                           String studentNumber, String major,
                           double gpa, double courseworkGPA,
                           double researchGPA) {

        super(id, name, email, studentNumber, major, gpa);
        this.courseworkGPA = courseworkGPA;
        this.researchGPA = researchGPA;
    }

    // Calculate graduate GPA
    @Override
    public double calculateGPA() {
        return (courseworkGPA * 0.7) + (researchGPA * 0.3);
    }
}
