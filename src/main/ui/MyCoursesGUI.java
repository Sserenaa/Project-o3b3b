package ui;

import model.Course;
import model.Event;
import model.EventLog;
import model.MyCourses;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.panels.MenuPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

// Represents the graphical user interface for this application
public class MyCoursesGUI extends JFrame implements ActionListener {

    private MyCourses myCourses;
    private JTextField courseNameField1;
    private JTextField profNameField;
    private JTextField gradeField;
    private JTextField courseNameField2;
    private MenuPanel menuPanel;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JList list;
    private DefaultListModel listModel;

    // EFFECTS: create a graphical user interface for the app
    public MyCoursesGUI() {
        super("MyCourses App");
        myCourses = new MyCourses();
        jsonWriter = new JsonWriter("./data/myCourses.json");
        jsonReader = new JsonReader("./data/myCourses.json");
        initWindow();
    }

    // MODIFIES: this
    // EFFECTS: create the initial window
    public void initWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 1200));
        this.setLayout(new BorderLayout());
        displayImage();
        makeListPanel();
        makeMenuPanel();
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {

            // EFFECTS: print to the console all the events that have been logged since the application started
            @Override
            public void windowClosing(WindowEvent e) {
                for (Event event : EventLog.getInstance()) {
                    System.out.println(event.toString());
                }
            }
        });
    }

    // EFFECTS: display an image
    public void displayImage() {
        JWindow window = new JWindow();
        try {
            window.getContentPane().add(new JLabel("    Welcome to MyCourses App!",
                    new ImageIcon(ImageIO.read(new URL("https://c.tenor.com/pvFJwncehzIAAAAC/hello-there-private-from-penguins-of-madagascar.gif"))),
                    SwingConstants.CENTER));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        window.setBounds(350, 150, 800, 550);
        window.setVisible(true);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(true);
        window.dispose();
    }

    // MODIFIES: this
    // EFFECTS: make the list panel
    //the methods is implemented from ListDemo linked below:
    //https://docs.oracle.com/javase/tutorial/uiswing/examples/components/ListDemoProject/src/components/ListDemo.java
    public void makeListPanel() {
        listModel = new DefaultListModel();
        list = new JList(listModel);
        list.setVisibleRowCount(10);
        JScrollPane listScrollPane = new JScrollPane(list);
        this.add(listScrollPane, BorderLayout.CENTER);
    }

    // MODIFIES: this
    //EFFECTS: make the menu panel
    public void makeMenuPanel() {
        menuPanel = new MenuPanel();
        JButton addButton = menuPanel.getAddButton();
        JButton removeButton = menuPanel.getRemoveButton();
        JButton loadButton = menuPanel.getLoadButton();
        JButton saveButton = menuPanel.getSaveButton();
        courseNameField1 = menuPanel.getCourseNameField1();
        profNameField = menuPanel.getProfNameField();
        gradeField = menuPanel.getGradeField();
        courseNameField2 = menuPanel.getCourseNameField2();
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        loadButton.addActionListener(this);
        saveButton.addActionListener(this);
        courseNameField1.addActionListener(this);
        profNameField.addActionListener(this);
        gradeField.addActionListener(this);
        courseNameField2.addActionListener(this);
        this.add(menuPanel, "South");
    }

    // EFFECTS: the app dose certain actions when different ActionEvent happens
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add") && courseNameField1.getText().length() > 0
                && profNameField.getText().length() > 0 && gradeField.getText().length() > 0) {
            addCourseFunction();
        } else if (e.getActionCommand().equals("Remove") && courseNameField2.getText().length() > 0) {
            removeCourseFunction();
        } else if (e.getActionCommand().equals("Load")) {
            loadFunction();
        } else if (e.getActionCommand().equals("Save")) {
            saveFunction();
        }
    }

    // MODIFIES: this
    // EFFECTS: add a course
    public void addCourseFunction() {
        Course course = new Course(courseNameField1.getText(),
                profNameField.getText(),
                Double.valueOf(gradeField.getText()));
        if (myCourses.addCourse(course)) {
            listModel.addElement(courseNameField1.getText());
            addSuccessWindow();
        } else {
            courseNameField1.setText("Please try again! Hint: You may haven take this course before.");
        }
    }

    // MODIFIES: this
    // EFFECTS: remove a course
    public void removeCourseFunction() {
        String courseName = courseNameField2.getText();
        if (myCourses.removeCourse(courseName)) {
            listModel.removeElement(courseNameField2.getText());
            removeSuccessWindow();
        } else {
            courseNameField2.setText("Please try again! Hint: You may not have taken this course before.");
        }
    }

    // MODIFIES: this
    // EFFECTS: load the myCourses list
    public void loadFunction() {
        try {
            myCourses = jsonReader.read();
            for (Course courseTaken: myCourses.getCourses()) {
                listModel.addElement(courseTaken.getCourseName());
            }
            loadSuccessWindow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // MODIFIES: this
    // EFFECTS: save the myCourses list
    public void saveFunction() {
        try {
            jsonWriter.open();
            jsonWriter.write(this.myCourses);
            jsonWriter.close();
            saveSuccessWindow();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    // EFFECTS: show the information that the course is successfully added
    // when addButton is pressed and the course is successfully added into myCourses list
    public void addSuccessWindow() {
        JFrame addSuccessFrame = new JFrame();
        addSuccessFrame.getContentPane().add(
                new JLabel("The course is successfully added!", SwingConstants.CENTER));
        addSuccessFrame.setBounds(550, 200, 300, 200);
        addSuccessFrame.setVisible(true);
    }

    // EFFECTS: show the information that the course is successfully removed
    // when removeButton is pressed and the course is successfully removed from myCourses list
    public void removeSuccessWindow() {
        JFrame removeSuccessFrame = new JFrame();
        removeSuccessFrame.getContentPane().add(
                new JLabel("The course is successfully removed!", SwingConstants.CENTER));
        removeSuccessFrame.setBounds(550, 200, 300, 200);
        removeSuccessFrame.setVisible(true);

    }

    // EFFECTS: show the information that the myCourses list is successfully loaded
    // when loadButton is pressed
    public void loadSuccessWindow() {
        JFrame loadSuccessFrame = new JFrame();
        loadSuccessFrame.getContentPane().add(
                new JLabel("The myCourses list is successfully loaded!", SwingConstants.CENTER));
        loadSuccessFrame.setBounds(550, 200, 300, 200);
        loadSuccessFrame.setVisible(true);

    }

    // EFFECTS: show the information that the myCourses list is successfully saved
    // when saveButton is pressed
    public void saveSuccessWindow() {
        JFrame saveSuccessFrame = new JFrame();
        saveSuccessFrame.getContentPane().add(
                new JLabel("The myCourses list is successfully saved!", SwingConstants.CENTER));
        saveSuccessFrame.setBounds(550, 200, 300, 200);
        saveSuccessFrame.setVisible(true);
    }

}
