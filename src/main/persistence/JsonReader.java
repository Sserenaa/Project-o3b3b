package persistence;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Course;
import model.MyCourses;
import org.json.*;

// JsonReader functionality and methods are implemented from JsonSerializationDemo linked below:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Represents a reader that reads myCourses list from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads myCourses list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public MyCourses read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseMyCourses(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    // throws IOException if an error occurs reading data as string
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses myCourses from JSON object and returns it
    private MyCourses parseMyCourses(JSONObject jsonObject) {
        MyCourses myCourses = new MyCourses();
        addCourses(myCourses, jsonObject);
        return myCourses;
    }

    // MODIFIES: myCourses
    // EFFECTS: parses courses from JSON object and adds them to myCourses list
    private void addCourses(MyCourses myCourses, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("courses");
        for (Object json : jsonArray) {
            JSONObject nextCourse = (JSONObject) json;
            addCourse(myCourses, nextCourse);
        }
    }

    // MODIFIES: myCourses
    // EFFECTS: parses course from JSON object and adds it to myCourses list
    private void addCourse(MyCourses myCourses, JSONObject jsonObject) {
        String courseName = jsonObject.getString("course's name");
        String profName = jsonObject.getString("prof's name");
        double grade = jsonObject.getDouble("grade");
        Course course = new Course(courseName, profName, grade);
        myCourses.addCourse(course);
    }
}


