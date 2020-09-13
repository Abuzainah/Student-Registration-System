package com.abd;


import java.util.ArrayList;

public class Course {

    private int courseId;
    private String courseName;
    private ArrayList<Student>studentsTakingTheCourseList=new ArrayList<>();
    private ArrayList<Instructor>instructorsTeachingTheCourseList=new ArrayList<>();

    public ArrayList<Student> getStudentsTakingTheCourseList() {
        return studentsTakingTheCourseList;
    }

    public void setStudentsTakingTheCourseList(ArrayList<Student> studentsTakingTheCourseList) {
        this.studentsTakingTheCourseList = studentsTakingTheCourseList;
    }

    public ArrayList<Instructor> getInstructorsTeachingTheCourseList() {
        return instructorsTeachingTheCourseList;
    }

    public void setInstructorsTeachingTheCourseList(ArrayList<Instructor> instructorsTeachingTheCourseList) {
        this.instructorsTeachingTheCourseList = instructorsTeachingTheCourseList;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
