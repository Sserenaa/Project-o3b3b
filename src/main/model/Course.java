package model;

public class Course {

    private String courseName;
    private String profName;
    private double grade;

    // REQUIRES: 0 <= grade <= 100
    // EFFECTS: create a new course
    public Course(String courseName, String profName, double grade) {
        this.courseName = courseName; // stub
        this.profName = profName;
        this.grade = grade;
    }

    // REQUIRES: 0 <= grade <= 100
    // EFFECTS: set the grade of course
    public void setGrade(double grade) {
        this.grade = grade;
    }

    // EFFECTS: get the name of the course
    public String getCourseName() {
        return courseName;
    }

    // EFFECTS: get the prof's name of the course
    public String getProfName() {
        return profName;
    }

    // EFFECTS: get the grade of the course
    public double getGrade() {
        return grade;
    }




}
