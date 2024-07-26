package com.vls;

import com.vls.model.Course;
import com.vls.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CourseServiceTest {
    private CourseService courseService;

    @BeforeEach
    // Setup the Testing
    public void setUp() {
        courseService = new CourseService();
        System.out.println("Setup Successful");
    }

    @Test
    public void testGetCourse() {
        // get course using courseName
        Course course = courseService.getCourse("Java");
        // assertNotNull -> checks whether the course is not null
        assertNotNull(course);
        // assertEquals -> checks the expected and actual
        assertEquals("Java", course.getCourseName());
    }

    @Test
    public void testGetAllCourses() {
        List<Course> courses = courseService.getDetailsOfAllCourses();
        // assertNotNull -> checks whether the courses is not null
        assertNotNull(courses);
        // assertTrue -> given statement is true
        assertTrue(courses.size() > 0);
    }

    @Test
    public void testAddCourse() {
        Course myCourse = new Course(6, "C#","Pavan", 10, true);
        // assertTrue -> given statement is true
        assertTrue(courseService.addCourse(myCourse));
    }


    @Test
    public void testDeleteCourse() {
        Course course = new Course(6, "C#", "Pavan", 10, true);
        courseService.addCourse(course);
        // assertTrue -> given statement is true
        assertTrue(courseService.deleteCourse(course));
    }

    @Test
    void testCheckCourseExists() {
        Course course = courseService.getCourse("Java");
        // assertNotNull -> checks whether the course is not null
        assertNotNull(course);
        // assertEquals -> checks the expected and actual
        assertEquals("Java", course.getCourseName());
    }


}
