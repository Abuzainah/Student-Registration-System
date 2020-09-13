package com.abd;
import java.util.ArrayList;

public class Instructor {


    private int instructorId;
    private String instructorFirstName;
    private String instructorLastName;
    private String password;
    
    
    public String getInstructorPassword() {

        return password;
    }

    public void setInstructorPassword(String password) {
        this.password = password;
    }

    public int getInstructorId() {

        return instructorId;
    }

    public void setInstructorId(int instructorId) {

        this.instructorId = instructorId;
    }

    public String getInstructorFirstName() {

        return instructorFirstName;
    }

    public void setInstructorFirstName(String instructorFirstName) {

        this.instructorFirstName = instructorFirstName;
    }

    public String getInstructorLastName() {
        return instructorLastName;
    }

    public void setInstructorLastName(String instructorLastName) {
        this.instructorLastName = instructorLastName;
    }

}
