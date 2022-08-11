# My Personal Project

## MyCourses Application

- What will the application do?  

    The application can creat a list of courses that users have taken before. Users also can put some information of ecah course like the **course name**, the **professor's name**, and the **user's grade of the course** (the grade on a scale of 0 to 100).
    
- Who will use it? 

    Any student who has taken courses in any school (but all of these courses must be taken in the same school) can use this application to help them to record their courses. 

- Why is this project of interest to you? 
    
    I would like to have an application that can give me a clear summary of courses that I've taken. For example, the application can show all names of courses such that it's easy to notice that which courses I need to take in order to meet the requirements of graduation in the future. I also can use this application to record my grades and calculate the average grade of all courses, which is useful for monitoring my grades.
    
- User stories 
    - As a user, I want to be able to add a course to the list my courses. 
    - As a user, I want to be able to remove a course to the list my courses (I can drop courses).
    - As a user, I want to be able to list all names of courses in the list my courses. 
    - As a user, I want to be able to select a course in the list of my courses and view all the information of this course.
    - As a user, I want to be able to select a course in the list of my courses and I can change the grade of this course.
    - As a user, I want to be able to see the number of courses in my courses list
    - As a user, I want to be able to see the average grade of courses in my courses list.
    - As a user, I want to be able to save my courses list to file.
    - As a user, I want to be able to load my courses list from file.

- References
    - JsonSerializationDemo: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    - ListDemo: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/ListDemoProject/src/components/ListDemo.java

- Instructions for Grader
    - You can generate the add a course event by entering the information (course's name, prof's name, and grade) at the bottom of the app, and click the "Add Course" button.
    - You can generate the remove a course event by entering the course's name at the bottom of the app, and click the "Remove Course" button.
    - You can locate the "hello" image by the link: https://c.tenor.com/pvFJwncehzIAAAAC/hello-there-private-from-penguins-of-madagascar.gif
    - You can save the state of myCourses list by click the "Save" button at the bottom of the app.
    - You can reload the state of myCourses list by click the "Load" button at the bottom of the app.

- Phase 4: Task 2
    - Example:

        Wed Aug 10 18:59:46 PDT 2022

        STAT201 (Bruce, 97.9) is added into myCourses list.

        Wed Aug 10 19:00:07 PDT 2022

        STAT300 (Steven, 60.3) is added into myCourses list.

        Wed Aug 10 19:00:39 PDT 2022

        CPSC210 (mushroom, 87.0) is added into myCourses list.

        Wed Aug 10 19:00:46 PDT 2022

        STAT201 is removed from myCourses list.
        
    - If a user opens MyCourses App and only click the "Save" button, and then he/she quit the App, print to the console no event (no event has been logged), because there is not any course that is added or removed (events are only logged when the user add/remove a course).     
    
- Phase 4: Task 3
    
    If I had more time to work on the project, there is a refactoring that I would do to improve my design. In MenuPanel class, there are two methods, createAddFieldPanel() and createRemoveFieldPanel(), and there are two for-each loops that is used to add labels and fields to the field panels in the two methods, but the two loops are the same, which is a duplicate code. I would like to extract a method which will call the for-each loops in MenuPanel and call that method from inside createAddFieldPanel() and createRemoveFieldPanel() instead.



