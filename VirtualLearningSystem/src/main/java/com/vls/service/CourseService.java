package com.vls.service;

import com.vls.model.Course;
import com.vls.repository.CourseRepository;

import java.util.List;

public class CourseService {
    private CourseRepository courseRepository;

    public CourseService() {
        this.courseRepository = new CourseRepository();
    }

    // logic for displaying details of all courses
    public List<Course> getDetailsOfAllCourses() {
        return courseRepository.getDetailsOfAllCourses();
    }

    // logic for search using coursename
    public Course getCourse(String courseName) {
        return courseRepository.getCourse(courseName);
    }

    // logic for add course

    public boolean addCourse(Course course) {
        return courseRepository.addCourse(course);
    }

    // logic for delete course
    public boolean deleteCourse(Course course) {
        return courseRepository.deleteCourse(course);
    }

    private void validationOfCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course can't be null..");
        }

        if (course.getDuration() <= 0) {
            throw new IllegalArgumentException("Duration must be a positive!!..");
        }

    }

}
