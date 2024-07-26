package com.vls.ui;

import com.vls.model.Course;
import com.vls.service.CourseService;

import java.util.List;

public class App {

    private static CourseService courseService = new CourseService();

    public static void main(String[] args) {
        // login loginID and password
        String loginId = "varshi";
        String password = "varshi123";

        if(login(loginId, password)) {
            System.out.println("Login successful");
            performCRUDOperations();
            System.out.println("Logout successful");
        }
        else {
            System.out.println("Login failed");
        }
    }

    private static boolean login(String loginId, String password) {
        // the below checks the loginId and password matches or not
        return "varshi".equals(loginId) && "varshi123".equals(password);
    }
    private static void performCRUDOperations() {

        // add courses
        courseService.addCourse(new Course(4,"NET", "Vani", 15, true));
        courseService.addCourse(new Course(5, "C++", "Rama", 20, true));

        // display details of all courses
        List<Course> allCourses = courseService.getDetailsOfAllCourses();
        for (Course course : allCourses) {
            System.out.println("Course Name: " + course.getCourseName() +
                    ", Author Name: " + course.getAuthorName() + ", Duration: " + course.getDuration() +
                    ", Availability: " + course.getAvailability());
        }

        // search course by courseName
        Course course = courseService.getCourse("Python");
        System.out.println("Course ID: " + course.getCourseID() + ", Course Name: " + course.getCourseName() +
                ", Author Name: " + course.getAuthorName() + ", Duration: " + course.getDuration() +
                ", Availability: " + course.getAvailability());


        // delete course
        courseService.deleteCourse(course);


        }

    }

