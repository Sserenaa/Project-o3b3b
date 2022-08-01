package persistence;

import model.Course;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    protected void checkCourse(String courseName, String profName, double grade, Course course) {
        assertEquals(courseName, course.getCourseName());
        assertEquals(profName, course.getProfName());
        assertEquals(grade, course.getGrade());
    }
}
