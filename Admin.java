package com.abd;

import java.util.ArrayList;

public class Admin {

    private int adminId;
    private String adminFirstName;
    private String adminLastName;
    private String adminPassword;
    private static ArrayList<Student>studentsList=new ArrayList<>();
    private static ArrayList<Instructor>instructorsList=new ArrayList<>();
    private static ArrayList<Course>coursesList=new ArrayList<>();
    
    
    public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
 
    public static boolean createStudent(int id,String firstName,String lastName,String password,String department){
        Student student=new Student();
        student.setStudentId(id);
        student.setStudentFirstName(firstName);
        student.setStudentLastName(lastName);
        student.setPassword(password);
        student.setDepartment(department);
        studentsList.add(student);
        boolean result=StudentDAO.addStudent(student);
        return result;
    }

    public static boolean createInstructor(int id,String firstName,String lastName,String password){
        Instructor instructor=new Instructor();
        instructor.setInstructorId(id);
        instructor.setInstructorFirstName(firstName);
        instructor.setInstructorLastName(lastName);
        instructor.setInstructorPassword(password);
        instructorsList.add(instructor);
        boolean result=InstructorDAO.addInstructor(instructor);
        return result;
    }
    
    public static boolean createCourse(int id,String name){
        Course course=new Course();
        course.setCourseId(id);
        course.setCourseName(name);
        coursesList.add(course);
        boolean result= CourseDAO.addCourse(course);
        return result;
    }

    public static void addEnrollment(Instructor instructor,Course course,Student student){
        EnrollmentDAO.addEnrollment(student,instructor,course);
    }
    public static ArrayList<Student>showStudents(){
    	return studentsList;
    }
    public static ArrayList<Course>showCourses(){
    	return coursesList;
    }
    public static ArrayList<Instructor>showInstructors(){
    	return instructorsList;
    }
}
