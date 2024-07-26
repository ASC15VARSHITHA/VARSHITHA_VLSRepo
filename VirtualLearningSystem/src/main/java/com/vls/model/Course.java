package com.vls.model;

public class Course {
    private int courseID;
    private String courseName;
    private String authorName;
    private int duration;
    private boolean availability;

    // default constructor
    public Course() {}

    // constructor
    public Course(int courseID, String courseName, String authorName, int duration, boolean availability) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.authorName = authorName;
        this.duration = duration;
        this.availability = availability;
    }

    // getters and setters
    public int getCourseID() {
        return courseID;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean getAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
