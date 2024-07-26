package com.vls.repository;

import com.vls.model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    private Connection connection;

    public CourseRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/VLSDB", "root", "mysql");
            System.out.println("Connection established");
        }
        catch (ClassNotFoundException | SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    // search operation - search for courses by authorName or courseName

    public Course getCourse(String courseName) {
        try {
            String query = "SELECT * FROM Course WHERE courseName = '" + courseName + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return new Course(resultSet.getInt("courseID"), resultSet.getString("courseName"),
                        resultSet.getString("authorName"), resultSet.getInt("duration"),
                        resultSet.getBoolean("availability"));
            }
        }
        catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }



// display details of courses

    public List<Course> getDetailsOfAllCourses() {
        List<Course> courses = new ArrayList<>();
        try {
            String query = "SELECT * FROM Course";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                courses.add(new Course((resultSet.getInt("courseID")),(resultSet.getString("courseName")),
                        resultSet.getString("authorName"), resultSet.getInt("duration"),
                        resultSet.getBoolean("availability")));
            }
        }
        catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return courses;
    }

    // add operation - add course

    public boolean addCourse(Course course) {
        try {
            String query = "INSERT INTO Course(courseName, authorName, duration, availability) VALUES('" +
                    course.getCourseName() + "', '" + course.getAuthorName() + "', " +
                    course.getDuration() + ", " + course.getAvailability() + ")";
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return result > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // delete operation - delete course

    public boolean deleteCourse(Course course) {
        try {
            String query = "DELETE FROM Course WHERE courseName = '" + course.getCourseName() + "'";
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return result > 0;
        }
        catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return false;
    }

}
