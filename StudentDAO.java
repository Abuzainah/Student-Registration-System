package com.abd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class StudentDAO {
	public static ConnectionPool pool=new ConnectionPool(10,"jdbc:mysql://localhost:3306/studentsystem","root","root");
	
	 public static boolean isThereSuchAStudent(int id){
	        Connection connection=pool.getConnection();

	        try{
	            Statement statement=connection.createStatement();
	            String sql="select * from students where studentid="+id;
	            ResultSet resultSet=statement.executeQuery(sql);
	            if(resultSet.next()){
	                return true;
	            }
	        }
	        catch (SQLException e){
	            e.printStackTrace();
	        }
	        finally {
	        	pool.returnConnection(connection);
	        }
	        return false;
	    }
	 
    
    public static boolean isThereSuchAStudent(int id,String password){
        Connection connection=pool.getConnection();

        try{
            Statement statement=connection.createStatement();
            String sql="select * from students where studentid="+id+" and studentpassword="+password;
            ResultSet resultSet=statement.executeQuery(sql);
            if(resultSet.next()){
                return true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
        	pool.returnConnection(connection);
        }
        return false;
    }
    

    public static Student getStudentByIdAndPassword(int id,String password){
        Connection connection=pool.getConnection();
        Student student=new Student();
        try{
            Statement statement=connection.createStatement();
            String sql="select * from students where studentid="+id+" and studentpassword="+password;
            ResultSet resultSet=statement.executeQuery(sql);
            if(resultSet.next()){
                student.setStudentId(resultSet.getInt(1));
                student.setPassword(resultSet.getString(4));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
        	pool.returnConnection(connection);
        }
        return student;
    }
    public static Student getStudent(int studentId){
        Connection connection=pool.getConnection();
        Student student=new Student();
        try{
            Statement statement=connection.createStatement();
            String sql="select * from students where studentid ="+studentId;
            ResultSet resultSet=statement.executeQuery(sql);
            if(resultSet.next()){
                student.setStudentId(resultSet.getInt(1));
                student.setStudentFirstName(resultSet.getString(2));
                student.setStudentLastName(resultSet.getString(3));
                student.setPassword(resultSet.getString(4));
                student.setDepartment(resultSet.getString(5));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
        	pool.returnConnection(connection);
        }
        return student;
    }
    public static void deleteStudent(int studentId){
        Connection connection=pool.getConnection();
        try{
            Statement statement=connection.createStatement();
            String sql="delete from students where studentid = "+studentId;
            statement.executeUpdate(sql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
       finally {
    	   pool.returnConnection(connection);
       }
    }

    public static boolean addStudent(Student student){
    	 int result=0;
        Connection connection=pool.getConnection();
        try{
            Statement statement=connection.createStatement();
            String sql="insert into students values("+student.getStudentId()+",'"+student.getStudentFirstName()+"','"+student.getStudentLastName()+
                    "','"+student.getPassword()+"','"+student.getDepartment()+"')";
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
    public static ArrayList<Course> enrolledCourse(int studentId){
    	Connection connection=pool.getConnection();
    	ArrayList<Course>courseList=new ArrayList<>();
    	try {
    		 Statement statement=connection.createStatement();
    		 String sql="select courseid , coursename from enrollment where studentid="+studentId;
    		 ResultSet resultSet=statement.executeQuery(sql);
    		 while(resultSet.next()) {
    			 Course course = new Course();
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
}
