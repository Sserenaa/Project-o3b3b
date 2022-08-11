package model;


import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// Represents a myCourses list having a collection of courses that the user has taken
public class MyCourses implements Writable {
    // delete or rename this class!

    private ArrayList<Course> myCourses;

    // EFFECTS: create an empty list of courses
    public MyCourses() {
        this.myCourses = new ArrayList<>();
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
        EventLog.getInstance().logEvent(new Event(course.getCourseName()
                + " (" + course.getProfName() + ", " + course.getGrade() + ")"
                + " is added into myCourses list."));
        return true;
    }

    // REQUIRES: the courseName should include a subject code and a course number
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
                EventLog.getInstance().logEvent(new Event(courseName + " is removed from myCourses list."));
                return true;
            }
        }
        return false;
    }

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

    // EFFECTS: return all courses in the myCourses list
    public ArrayList<Course> getCourses() {
        return myCourses;
    }

    // REQUIRES: the courseName should include a subject code and a course number
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

    // REQUIRES: the courseName should include a subject code and a course number
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


    // REQUIRES: 0 <= newGrade <= 100;
    // the courseName should include a subject code and a course number
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

    // MODIFIES: json
    // EFFECTS: returns the courses arraylist as a JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("courses", coursesToJson());
        return json;
    }

    // MODIFIES: jsonArray
    // EFFECTS: returns courses in this myCourses list as a JSON array
    private JSONArray coursesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Course course : myCourses) {
            jsonArray.put(course.toJson());
        }

        return jsonArray;
    }
}
