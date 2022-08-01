package ui;

import model.Course;
import model.MyCourses;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

// Represents the MyCourses application
public class MyCoursesApp {

    private MyCourses myCourses;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/myCourses.json";

    // EFFECTS: constructs myCourses and runs application
    public MyCoursesApp() {
        myCourses = new MyCourses();
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runMyCourseApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    public void runMyCourseApp() {
        String operation = null;
        boolean stillRun = true;

        while (stillRun) {
            showMenu();
            operation = input.next().toLowerCase();
            if (operation.equals("quit")) {
                stillRun = false;
                System.out.println("Goodbye! Thank you for using this app!");
            } else {
                processesOperation(operation);
                System.out.println("\n");
            }
        }
    }


    // EFFECTS: shows Menu of operations that the app can do to user
    public void showMenu() {
        System.out.println("Welcome to MyCourses App! Please select an operation that you would like to do: ");
        System.out.println("\tadd -> add a course");
        System.out.println("\tremove -> remove a course");
        System.out.println("\tlist -> list all names of courses");
        System.out.println("\tview -> view all information of a course");
        System.out.println("\tchange -> change the grade of a course");
        System.out.println("\tnumber -> see the number of courses");
        System.out.println("\taverage -> see the average of all courses");
        System.out.println("\tsave -> save my courses list to file");
        System.out.println("\tload -> load my courses list from file");
        System.out.println("\tquit");
    }

    // MODIFIES: this
    // EFFECTS: processes user's operation
    private void processesOperation(String operation) {
        if (operation.equals("add")) {
            addCourse();
        } else if (operation.equals("remove")) {
            removeCourse();
        } else if (operation.equals("list")) {
            listCoursesName();
        } else if (operation.equals("view")) {
            viewInformation();
        } else if (operation.equals("change")) {
            changeGrade();
        } else if (operation.equals("number")) {
            seeNumber();
        } else if (operation.equals("average")) {
            seeAverage();
        } else if (operation.equals("save")) {
            saveMyCoursesList();
        } else if (operation.equals("load")) {
            loadMyCoursesList();
        } else {
            System.out.println("Selection is not valid. Please select again.");
        }
    }

    // MODIFIES: this
    // EFFECTS: add a course
    public void addCourse() {
        System.out.print("Enter the information of the course that you would like to add.");
        System.out.print("\nEnter the course's name: ");
        String courseName = input.next().toUpperCase(Locale.ROOT);
        System.out.print("Enter the professor's name of the course: ");
        String profName = input.next();
        System.out.print("Enter the grade of the course (on a scale of 0 to 100): ");
        double grade = input.nextDouble();
        Course courseAdd = new Course(courseName, profName, grade);
        if (myCourses.addCourse(courseAdd)) {
            System.out.println("The course is successfully added!");
        } else {
            System.out.println("You've already taken " + courseName + ". The course cannot be added again.");
        }
    }

    // MODIFIES: this
    // EFFECTS: remove a course
    public void removeCourse() {
        System.out.println("Enter the name of the course that you would like to remove: ");
        String courseName = input.next().toUpperCase(Locale.ROOT);
        if (myCourses.removeCourse(courseName)) {
            System.out.println("The course is successfully removed!");
        } else {
            System.out.println("Error! The course is not found!");
        }
    }


    // EFFECTS: list all names of courses
    public void listCoursesName() {
        System.out.println(myCourses.listAllCourses());
    }

    // MODIFIES: this
    // EFFECTS: view the information of the course selected
    public void viewInformation() {
        System.out.println("Enter the name of the course that you would like to view: ");
        String courseName = input.next().toUpperCase(Locale.ROOT);
        System.out.println("The Name of the course: " + courseName);
        System.out.println("The prof's name of the course: " + myCourses.getProfName(courseName));
        if (myCourses.getGrade(courseName) == -1) {
            System.out.println("The grade of the course: No results found. You haven't take this course.");
        } else {
            System.out.println("The grade of the course: " + myCourses.getGrade(courseName));
        }
    }

    // MODIFIES: this
    // EFFECTS: change grade of the course selected
    public void changeGrade() {
        System.out.println("Enter the name of the course that you would like to change its grade: ");
        String courseName = input.next().toUpperCase(Locale.ROOT);
        System.out.println("Enter the new grade (on a scale of 0 to 100): ");
        double newGrade = input.nextDouble();
        if (myCourses.changeGrade(courseName, newGrade)) {
            System.out.println("The grade of " + courseName + " is changed to " + newGrade + ".");
        } else {
            System.out.println("Error! Cannot find this course!");
        }
    }

    // EFFECTS: see the number of all courses
    public void seeNumber() {
        System.out.println("The total number of courses that you've taken: " + myCourses.theNumberOfCourses());
    }

    // EFFECTS: see the average grade of all courses
    public void seeAverage() {
        System.out.println("The average grade of courses that you've taken: " + myCourses.averageGrade());
    }

    // EFFECTS: saves the myCourses list to file
    private void saveMyCoursesList() {
        try {
            jsonWriter.open();
            jsonWriter.write(myCourses);
            jsonWriter.close();
            System.out.println("Saved the myCourses list to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads myCourses list from file
    private void loadMyCoursesList() {
        try {
            myCourses = jsonReader.read();
            System.out.println("Loaded myCourses list from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    public static void main(String[] args) {
        new MyCoursesApp();
    }
}
