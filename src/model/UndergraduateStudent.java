package model;

public class UndergraduateStudent extends Student {

    private double[] gradePoints;
    private int[] creditHours;

    // Constructor
    public UndergraduateStudent(int id, String name, String email,
                                String studentNumber, String major,
                                double gpa, double[] gradePoints,
                                int[] creditHours) {

        super(id, name, email, studentNumber, major, gpa);

        this.gradePoints = gradePoints;
        this.creditHours = creditHours;
    }

    // Calculate GPA using credit hours
    @Override
    public double calculateGPA() {

        double totalPoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < gradePoints.length; i++) {
            totalPoints += gradePoints[i] * creditHours[i];
            totalCredits += creditHours[i];
        }

        if (totalCredits == 0) {
            return 0.0;
        }

        return totalPoints / totalCredits;
    }
}