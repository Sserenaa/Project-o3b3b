package model;


import java.util.ArrayList;

public class MyCourses {
    // delete or rename this class!

    private ArrayList<Course> myCourses;

    // EFFECTS: create an empty list of courses
    public MyCourses() {
        this.myCourses = new ArrayList<>();
        // stub
    }

    // MODIFIES: this
    // EFFECTS: if there is a course (in the courses list) whose name
    // is the same as the name of this course, not add this course into
    // the list and return false;
    // if there is not any course (in the courses list) whose name
    // is the same as the name of this course, add this course into
    // the list and return true;
    public boolean addCourse(Course course) {
        for (Course courseTaken: myCourses) {
            if (courseTaken.getCourseName().equals(course.getCourseName())) {
                return false;
            }
        }
        myCourses.add(course);
        return true;
    }

    // MODIFIES: this
    // EFFECTS: if there is a course (in the courses list) whose name
    // is the same as courseName, remove the course with given courseName
    // from the list and return true;
    // if there is not any course (in the courses list) whose name
    // is the same as courseName, return false;
    public boolean removeCourse(String courseName) {
        for (Course courseTaken: myCourses) {
            if (courseTaken.getCourseName().equals(courseName)) {
                myCourses.remove(courseTaken);
                return true;
            }
        }
        return false;
    }

    // public void removeCourse() {

    //}

    // REQUIRES: myCourses is not empty???
    // EFFECTS: return all the names of courses in the myCourses list
    public ArrayList<String> listAllCourses() {
        ArrayList<String> coursesName = new ArrayList<>();
        if (myCourses.isEmpty()) {
            coursesName.add("The courses list is empty!");
        } else {
            for (Course courseTaken: myCourses) {
                coursesName.add(courseTaken.getCourseName());
            }
        }
        return coursesName;
    }

    //public String getCourseName(String courseName) {
    //    for (Course courseTaken: myCourses) {
    //        if (courseTaken.getCourseName() == courseName) {
    //            return courseTaken.getCourseName();
    //        }
    //    }
    //    return "No results found";
    //}

    // EFFECTS: return the professor's name of the course with
    // the given courseName
    public String getProfName(String courseName) {
        for (Course courseTaken: myCourses) {
            if (courseTaken.getCourseName().equals(courseName)) {
                return courseTaken.getProfName();
            }
        }
        return "No results found. You haven't take this course.";
    }

    // REQUIRES: the course with the given courseName is in the
    // myCourses list
    // EFFECTS: return the school's name of the course with
    // the given courseName
    // public String getSchoolName(String courseName) {
    //    return "";  // stub

    //}


    // EFFECTS: if the list contains the course with given courseName,
    // return the grade of this course;
    // if the list doesn't contain the course with the given courseName,
    // return -1
    public double getGrade(String courseName) {
        for (Course courseTaken: myCourses) {
            if (courseTaken.getCourseName().equals(courseName)) {
                return courseTaken.getGrade();
            }
        }
        return -1;
    }

    // REQUIRES: the course with the given courseName is in the
    // myCourses list
    // MODIFIES: this, grade
    // EFFECTS: change the grade of the course with
    // the given courseName to the value of newGrade and return true if the course
    // is in the list;
    // if the course is not in the list, return false;
    public boolean changeGrade(String courseName, double newGrade) {
        for (Course courseTaken: myCourses) {
            if (courseTaken.getCourseName().equals(courseName)) {
                courseTaken.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // EFFECTS: return the number of courses in the myCourses list
    public int theNumberOfCourses() {
        return myCourses.size();
    }

    // EFFECTS: return the average grade of all courses in the list;
    // if the list is empty, return 0;
    public double averageGrade() {
        if (!myCourses.isEmpty()) {
            double sum = 0;
            int i;
            double avg = 0;
            for (i = 0; i < myCourses.size(); i++) {
                sum = sum + myCourses.get(i).getGrade();
                avg = sum / myCourses.size();
            }
            return avg;
        } else {
            return 0;
        }
    }
}