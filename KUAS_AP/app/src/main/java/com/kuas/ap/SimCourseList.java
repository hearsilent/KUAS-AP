package com.kuas.ap;

public class SimCourseList {
    String courseName;
    String courseTime;
    String courseTeacher;
    String courseRoom;
    Integer courseCredit;
    public SimCourseList(String courseName, String courseTime, String courseTeacher, String courseRoom, Integer courseCredit)
    {
        this.courseName = courseName;
        if (courseTime.equals(" "))
            this.courseTime = "--------";
        else
            this.courseTime = courseTime;
        if (courseTeacher.equals(" "))
            this.courseTeacher = "--------";
        else
            this.courseTeacher = courseTeacher;
        if (courseRoom.equals(" "))
            this.courseRoom = "--------";
        else
            this.courseRoom = courseRoom;
        this.courseCredit = courseCredit;
    }
}