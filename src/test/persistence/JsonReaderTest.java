package persistence;

import model.Course;
import model.MyCourses;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            MyCourses myCourses = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyMyCourses() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyMyCourses.json");
        try {
            MyCourses myCourses = reader.read();
            assertEquals(0, myCourses.theNumberOfCourses());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralMyCourses() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralMyCourses.json");
        try {
            MyCourses myCourses = reader.read();
            ArrayList<Course> courses = myCourses.getCourses();
            assertEquals(2, courses.size());
            checkCourse("STAT201", "Bruce", 88, courses.get(0));
            checkCourse("CPSC210", "Mushroom", 80, courses.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}