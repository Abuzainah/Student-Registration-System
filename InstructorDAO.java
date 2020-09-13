package com.abd;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InstructorDAO {
	
	public static ConnectionPool pool=new ConnectionPool(10,"jdbc:mysql://localhost:3306/studentsystem","root","root");
	
	public static ArrayList<Instructor> getAvailableInstructors(){
        Connection connection=pool.getConnection();
        ArrayList<Instructor>instructorList=new ArrayList<Instructor>();
        try{
            String sql="select * from instructors ";
            Statement st=connection.createStatement();
            ResultSet resultSet=st.executeQuery(sql);
            while(resultSet.next()){
                Instructor instructor=new Instructor();
                instructor.setInstructorId(resultSet.getInt("instructorid"));
                instructor.setInstructorFirstName(resultSet.getString("instructorfirstname"));
                instructor.setInstructorLastName(resultSet.getString("instructorlastname"));
                instructorList.add(instructor);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        pool.returnConnection(connection);
        return instructorList;
    }
	
	public static boolean isThereSuchAnInstructor(int instructorId) {
		boolean result=false;
		Connection connection=pool.getConnection();
		try{
            Statement st=connection.createStatement();
            String sql="select * from instructors where instructorid="+instructorId;
            ResultSet set=st.executeQuery(sql);
            if(set.next()) {
            	result=true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
        	pool.returnConnection(connection);
        }
        return (result);
	}
    public static boolean isThereSuchAnInstructor(int id,String password){
        Connection connection=pool.getConnection();
        try{
            Statement statement=connection.createStatement();
            String sql="select * from instructors where instructorid="+id+" and instructorpassword="+password;
            ResultSet resultSet=statement.executeQuery(sql);
            if(resultSet.next()){
                return true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public static Instructor getInstructor(int instructorId){
        Connection connection=pool.getConnection();
        Instructor instructor=new Instructor();
        try{
            Statement st=connection.createStatement();
            String sql="select * from instructors where instructorid="+instructorId;
            ResultSet resultSet=st.executeQuery(sql);
            if(resultSet.next()){
                instructor.setInstructorId(resultSet.getInt(1));
                instructor.setInstructorFirstName(resultSet.getString(2));
                instructor.setInstructorLastName(resultSet.getString(3));
                instructor.setInstructorPassword(resultSet.getString(4));
            }
            pool.returnConnection(connection);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return instructor;
    }
    public static boolean addInstructor(Instructor instructor){
    	int result=0;
        Connection connection=pool.getConnection();
        try{
            Statement statement=connection.createStatement();
            String sql="insert into instructors values("+instructor.getInstructorId()+",'"+instructor.getInstructorFirstName()+"','"
                   +instructor.getInstructorLastName()+"','"+instructor.getInstructorPassword()+"')";
            result=statement.executeUpdate(sql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
       finally {
    	   pool.returnConnection(connection);
       }
        return (result>0);
    }
    public static void deleteInstructor(int instructorId){
        Connection connection=pool.getConnection();
        try{
            Statement statement=connection.createStatement();
            String sql="delete from instructors where instructorid ="+instructorId;
            statement.executeUpdate(sql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
     	   pool.returnConnection(connection);
        }
    }
    public static boolean increaseAbsenceForAStudent(int studentId,int courseId){
    	int result=0;
    	Connection connection=pool.getConnection();
    	int originalAbsence=InstructorDAO.returnAbsenceTimes(studentId)+1;
    	
    	try {
    		Statement statement=connection.createStatement();
    		String sql="update enrollment set absence = "+originalAbsence+" where studentid="+studentId+" and courseid= "+courseId;
    		result=statement.executeUpdate(sql);
    	}
    	 catch (SQLException e){
             e.printStackTrace();
         }
         finally {
      	   pool.returnConnection(connection);
         }
    	return(result>0);
    }
    public static int returnAbsenceTimes(int id) {
    	int result=0;
    	Connection connection=pool.getConnection();
    		 try{
    	            Statement statement=connection.createStatement();
    	            String sql="select absence from enrollment where studentid="+id;
    	            ResultSet resultSet=statement.executeQuery(sql); 
    	            if(resultSet.next()) {
    	            	result=resultSet.getInt("absence");
    	            }
    		 }
	    	 catch (SQLException e){
	             e.printStackTrace();
	         }
	         finally {
	      	   pool.returnConnection(connection);
	         }
    	return result;
    }
    public static boolean setGradeForAStudent(int studentId , double grade){
    	int result=0;
    	Connection connection=pool.getConnection();
    	    	
    	try {
    		Statement statement=connection.createStatement();
    		String sql="update enrollment set grade = "+grade+" where studentid = "+studentId;
    		result=statement.executeUpdate(sql);
    	}
    	 catch (SQLException e){
             e.printStackTrace();
         }
         finally {
      	   pool.returnConnection(connection);
         }
    	return(result>0);
    }
    public static ArrayList<Course>checkCoursesInstructorTeach(int instructorId){
    	
    	ArrayList<Course>courseList=new ArrayList<>();
    	Connection connection=pool.getConnection();
    	try {
    		Statement statement=connection.createStatement();
    		String sql="select courseid and coursename from enrollment where instructorid= "+instructorId;
    		ResultSet resultSet=statement.executeQuery(sql);
    		while(resultSet.next()) {
    			Course course=new Course();
    			course.setCourseId(resultSet.getInt("courseid"));
    			course.setCourseName(resultSet.getString("coursename"));
    			courseList.add(course);
    		}
    	}
    	 catch (SQLException e){
             e.printStackTrace();
         }
         finally {
      	   pool.returnConnection(connection);
         }
    	return courseList;
    }
    public static ArrayList<Student>checkStudentsInstructorTeach(int instructorId){
    	
    	ArrayList<Student>studentList=new ArrayList<>();
    	Connection connection=pool.getConnection();
    	try {
    		Statement statement=connection.createStatement();
    		String sql="select studentid and studentfirstname and studentlastname from enrollment where  instructorid= "+instructorId;
    		ResultSet resultSet=statement.executeQuery(sql);
    		while(resultSet.next()) {
    			Student student=new Student();
    			student.setStudentId(resultSet.getInt("studentid"));
    			student.setStudentFirstName(resultSet.getString("studentfirstname"));
    			student.setStudentLastName(resultSet.getString("studentlastname"));
    			studentList.add(student);
    		}
    	}
    	 catch (SQLException e){
             e.printStackTrace();
         }
         finally {
      	   pool.returnConnection(connection);
         }
    	return studentList;
    }
}
