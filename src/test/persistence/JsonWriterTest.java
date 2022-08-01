package persistence;

import model.Course;
import model.MyCourses;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            MyCourses myCourses = new MyCourses();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyMyCourses() {
        try {
            MyCourses myCourses = new MyCourses();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyMyCourses.json");
            writer.open();
            writer.write(myCourses);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyMyCourses.json");
            myCourses = reader.read();
            assertEquals(0, myCourses.theNumberOfCourses());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralMyCourses() {
        try {
            MyCourses myCourses = new MyCourses();
            myCourses.addCourse(new Course("STAT300", "Steven", 79));
            myCourses.addCourse(new Course("STAT201", "Bruce", 88));
            myCourses.addCourse(new Course("CPSC210", "Mushroom", 80));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralMyCourses.json");
            writer.open();
            writer.write(myCourses);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralMyCourses.json");
            myCourses = reader.read();
            ArrayList<Course> courses = myCourses.getCourses();
            assertEquals(3, courses.size());
            checkCourse("STAT300", "Steven", 79, courses.get(0));
            checkCourse("STAT201", "Bruce", 88, courses.get(1));
            checkCourse("CPSC210", "Mushroom", 80, courses.get(2));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
