package com.abd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EnrollmentDAO {

	public static ConnectionPool pool=new ConnectionPool(10,"jdbc:mysql://localhost:3306/studentsystem","root","root");
    public static void addEnrollment(Student student,Instructor instructor,Course course){
        Connection connection=pool.getConnection();
        try{
            Statement statement=connection.createStatement();
            String sql="insert into enrollment values("+student.getStudentId()+",'"+student.getStudentFirstName()+"','"+student.getStudentLastName()+"',"+
                    instructor.getInstructorId()+",'"+instructor.getInstructorFirstName()+"','"+instructor.getInstructorLastName()+"',"+
                    course.getCourseId()+",'"+course.getCourseName()+"',"+0+","+0+")";
            statement.executeUpdate(sql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
       finally {
    	   pool.returnConnection(connection);
       }
    }
    public static ArrayList<Student> getStudentsTakingTheCourse(int courseId){
        Connection connection=pool.getConnection();
        ArrayList<Student>students=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            String sql="select * from enrollment where courseid = "+courseId;
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                Student student=new Student();
                student.setStudentId(resultSet.getInt(1));
                student.setStudentFirstName(resultSet.getString(2));
                student.setStudentLastName(resultSet.getString(3));
                students.add(student);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
     	   pool.returnConnection(connection);
        }
        return students;
    }
    public static ArrayList<Instructor> getInstructorsTakingTheCourse(int courseId){
        Connection connection=pool.getConnection();
        ArrayList<Instructor>instructors=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            String sql="select * from enrollment where courseid = "+courseId;
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                Instructor instructor=new Instructor();
                instructor.setInstructorId(resultSet.getInt(4));
                instructor.setInstructorFirstName(resultSet.getString(5));
                instructor.setInstructorLastName(resultSet.getString(6));
                instructors.add(instructor);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
     	   pool.returnConnection(connection);
        }
        return instructors;
    }
    
	public static boolean isThereSuchAnEnrollment(int studentId, int courseId) {
		 Connection connection=pool.getConnection();
		 int count=0;
		 try{
	            Statement statement=connection.createStatement();
	            String sql="select * from enrollment where studentid="+studentId+" and courseid="+courseId;
	            ResultSet resultSet=statement.executeQuery(sql);
	            while (resultSet.next()){
	               count++;
	            }
	        }
	        catch (SQLException e){
	            e.printStackTrace();
	        }
		 finally {
	    	   pool.returnConnection(connection);
	       }
		 return(count==0);
	}
	
	public static boolean isThereSuchARecord(int studentId, int courseId) {
		 Connection connection=pool.getConnection();
		 int count=0;
		 try{
	            Statement statement=connection.createStatement();
	            String sql="select * from enrollment where studentid="+studentId+" and courseid="+courseId;
	            ResultSet resultSet=statement.executeQuery(sql);
	            while (resultSet.next()){
	               count++;
	            }
	        }
	        catch (SQLException e){
	            e.printStackTrace();
	        }
		 finally {
	    	   pool.returnConnection(connection);
	       }
		 return(count>0);
	}
	public static void deleteFromEnrollment(int courseId,int studentId) {
		Connection connection=pool.getConnection();
		try{
            Statement statement=connection.createStatement();
            String sql="delete from enrollment where studentid="+studentId+" and courseid="+courseId ;
            statement.executeUpdate(sql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
       finally {
    	   pool.returnConnection(connection);
       }
	}
	 public static ArrayList<Enrollment> showGrades(int studentId){
		 
		 Connection connection=pool.getConnection();
		 ArrayList<Enrollment>gradeList=new ArrayList<>();
		 
		 try {
			Statement statement=connection.createStatement();
			String sql="select * from enrollment where studentid="+studentId;
			ResultSet resultSet=statement.executeQuery(sql);	
			while(resultSet.next()) {
				Enrollment e=new Enrollment();
				e.setCourseId(resultSet.getInt("courseid"));
				e.setCourseName(resultSet.getString("courseName"));
				e.setGrade(resultSet.getDouble("grade"));
				gradeList.add(e);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		  finally {
	    	   pool.returnConnection(connection);
	       }
		return gradeList; 
	 }
	 public static ArrayList<Enrollment> showAbsense(int studentId){
		 
		 Connection connection=pool.getConnection();
		 ArrayList<Enrollment>absenceList=new ArrayList<>();
		 
		 try {
			Statement statement=connection.createStatement();
			String sql="select * from enrollment where studentid="+studentId;
			ResultSet resultSet=statement.executeQuery(sql);	
			while(resultSet.next()) {
				Enrollment e=new Enrollment();
				e.setCourseId(resultSet.getInt("courseid"));
				e.setCourseName(resultSet.getString("courseName"));
				e.setAbsense(resultSet.getInt("absence"));
				absenceList.add(e);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		  finally {
	    	   pool.returnConnection(connection);
	       }
		return absenceList; 
	 }
	 public static ArrayList<Enrollment>getStudentInstructorTeach(int instructorId){
		 Connection connection=pool.getConnection();
		 ArrayList<Enrollment>studentList=new ArrayList<>();
		 
		 try {
				Statement statement=connection.createStatement();
				String sql="select * from enrollment where instructorid="+instructorId;
				ResultSet resultSet=statement.executeQuery(sql);	
				while(resultSet.next()) {
					Enrollment e=new Enrollment();
					e.setCourseId(resultSet.getInt("courseid"));
					e.setCourseName(resultSet.getString("courseName"));
					e.setStudentId(resultSet.getInt("studentid"));
					e.setStudentFirstName(resultSet.getString("studentfirstname"));
					e.setStudentLastName(resultSet.getString("studentlastname"));
					e.setGrade(resultSet.getDouble("grade"));
					e.setAbsense(resultSet.getInt("absence"));
					studentList.add(e);
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			  finally {
		    	   pool.returnConnection(connection);
		       }
			return studentList; 
	 }
	 
	 public static ArrayList<Enrollment>getCourseInstructorTeach(int instructorId){
		 Connection connection=pool.getConnection();
		 ArrayList<Enrollment>courseList=new ArrayList<>();
		 
		 try {
				Statement statement=connection.createStatement();
				String sql="select * from enrollment where instructorid="+instructorId;
				ResultSet resultSet=statement.executeQuery(sql);	
				while(resultSet.next()) {
					Enrollment e=new Enrollment();
					e.setCourseId(resultSet.getInt("courseid"));
					e.setCourseName(resultSet.getString("courseName"));
					courseList.add(e);
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			  finally {
		    	   pool.returnConnection(connection);
		       }
			return courseList; 
	 }
}
