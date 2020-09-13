package com.abd;

import java.util.ArrayList;
public class Student {

    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private String password;
    private String department;
   

   

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {

        this.department = department;
    }

    public int getStudentId() {

        return studentId;
    }

    public void setStudentId(int studentId) {

        this.studentId = studentId;
    }

    public String getStudentFirstName() {

        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {

        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {

        this.studentLastName = studentLastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


 
}
