package model;

public class Course {

    private String courseName;
    private String profName;
    private double grade;

    public Course(String courseName, String profName, double grade) {
        this.courseName = courseName; // stub
        this.profName = profName;
        this.grade = grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getProfName() {
        return profName;
    }

    public double getGrade() {
        return grade;
    }




}
