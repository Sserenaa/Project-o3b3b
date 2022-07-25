package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class MyCoursesTest {
    // delete or rename this class!

    private MyCourses myCourses;
    private Course course1;
    private Course course2;
    private Course course3;
    private ArrayList<String> coursesName;


    @BeforeEach
    public void setUp() {
        myCourses = new MyCourses();
        course1 = new Course("STAT201", "Bruce", 88);
        course2 = new Course("STAT300", "Steven", 80);
        course3 = new Course("CPSC210", "Mushroom", 85);
    }

    @Test
    public void myCoursesConstructorTest(){
        assertEquals(0, myCourses.theNumberOfCourses());
    }

    @Test
    public void addCourseTest() {
        assertTrue(myCourses.addCourse(course1));
        assertEquals(1, myCourses.theNumberOfCourses());
        assertFalse(myCourses.addCourse(course1));
        assertEquals(1, myCourses.theNumberOfCourses());
        assertTrue(myCourses.addCourse(course2));
        assertEquals(2, myCourses.theNumberOfCourses());
    }

    @Test
    public void removeCourseTest() {

        myCourses.addCourse(course1);
        myCourses.addCourse(course2);
        assertEquals(2, myCourses.theNumberOfCourses());
        assertTrue(myCourses.removeCourse("STAT201"));
        assertEquals(1, myCourses.theNumberOfCourses());
        assertTrue(myCourses.removeCourse("STAT300"));
        assertEquals(0, myCourses.theNumberOfCourses());
        assertFalse(myCourses.removeCourse("STAT201"));
        assertFalse(myCourses.removeCourse("STAT300"));
        assertFalse(myCourses.removeCourse("CPSC210"));

    }

    @Test
    public void listAllCoursesTest() {

        coursesName = new ArrayList<>();
        coursesName.add("The courses list is empty!");
        assertEquals(coursesName, myCourses.listAllCourses());
        myCourses.addCourse(course1);
        myCourses.addCourse(course2);
        coursesName.remove("The courses list is empty!");
        coursesName.add("STAT201");
        coursesName.add("STAT300");
        assertEquals(coursesName, myCourses.listAllCourses());

    }

    @Test
    public void getProfNameTest() {

        myCourses.addCourse(course1);
        myCourses.addCourse(course2);
        assertEquals("Bruce", myCourses.getProfName("STAT201"));
        assertEquals("Steven", myCourses.getProfName("STAT300"));
        assertEquals("No results found. You haven't take this course.",
                myCourses.getProfName("CPSC210"));

    }

    @Test
    public void getGradeTest() {

        myCourses.addCourse(course1);
        myCourses.addCourse(course2);
        assertEquals(88, myCourses.getGrade("STAT201"));
        assertEquals(80, myCourses.getGrade("STAT300"));
        assertEquals(-1, myCourses.getGrade("CPSC210"));

    }

    @Test
    public void changeGradeTest() {

        myCourses.addCourse(course1);
        assertEquals(88, myCourses.getGrade("STAT201"));
        assertTrue( myCourses.changeGrade("STAT201", 90));
        assertEquals(90, myCourses.getGrade("STAT201"));
        assertFalse( myCourses.changeGrade("STAT300", 90));


    }

    @Test
    public void theNumberOfCoursesTest() {

        assertEquals(0, myCourses.theNumberOfCourses());
        myCourses.addCourse(course1);
        myCourses.addCourse(course2);
        myCourses.addCourse(course3);
        assertEquals(3, myCourses.theNumberOfCourses());

    }

    @Test
    public void averageGradeTest() {

        assertEquals(0, myCourses.averageGrade());
        myCourses.addCourse(course1);
        myCourses.addCourse(course2);
        myCourses.addCourse(course3);
        assertEquals(84.33333333333333, myCourses.averageGrade());

    }

}