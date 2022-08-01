package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {
    private Course course1;
    private Course course2;

    @BeforeEach
    public void setUp() {
        course1 = new Course("STAT201", "Bruce", 88);
        course2 = new Course("STAT300", "Steven", 80.5);
    }

    @Test
    public void setGradeTest() {
        course1.setGrade(85);
        assertEquals(85, course1.getGrade());
        course2.setGrade(91.75);
        assertEquals(91.75, course2.getGrade());
    }

    @Test
    public void getCourseNameTest() {
        assertEquals("STAT201", course1.getCourseName());
        assertEquals("STAT300", course2.getCourseName());

    }

    @Test
    public void getProfNameTest() {
        assertEquals("Bruce", course1.getProfName());
        assertEquals("Steven", course2.getProfName());
    }

    @Test
    public void getGradeTest() {
        assertEquals(88, course1.getGrade());
        assertEquals(80.5, course2.getGrade());
    }

}
