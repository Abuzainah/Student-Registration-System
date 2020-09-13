package com.abd;


import java.sql.*;
import java.util.ArrayList;

public class CourseDAO {

	public static ConnectionPool pool=new ConnectionPool(10,"jdbc:mysql://localhost:3306/studentsystem","root","root");
	
		public static boolean isThereSuchACourse(int courseId) {
			boolean result=false;
			Connection connection=pool.getConnection();
			try{
                Statement st=connection.createStatement();
                String sql="select * from courses where courseid="+courseId;
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
        public static boolean addCourse(Course course){
        	int result=0;
            Connection connection=pool.getConnection();
            try{
                Statement st=connection.createStatement();
                String sql="insert into courses values("+course.getCourseId()+",'"+course.getCourseName()+"')";
                result=st.executeUpdate(sql);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            finally {
            	pool.returnConnection(connection);
            }
            return (result>0);
        }
        public static Course getCourse(int courseId){
            Connection connection=pool.getConnection();
            Course course=new Course();
            try{
                String sql="select * from courses where courseid = "+courseId;
                Statement st=connection.createStatement();
                ResultSet resultSet=st.executeQuery(sql);
                if(resultSet.next()){
                    course.setCourseId(resultSet.getInt(1));
                    course.setCourseName(resultSet.getString(2));
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            pool.returnConnection(connection);
            return course;
        }
        
        
        public static ArrayList<Course> getAvailableCourse(){
            Connection connection=pool.getConnection();
            ArrayList<Course>courseList=new ArrayList<Course>();
            try{
                String sql="select * from courses ";
                Statement st=connection.createStatement();
                ResultSet resultSet=st.executeQuery(sql);
                while(resultSet.next()){
                    Course course=new Course();
                    course.setCourseId(resultSet.getInt("courseid"));
                    course.setCourseName(resultSet.getString("courseName"));
                    courseList.add(course);
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            pool.returnConnection(connection);
            return courseList;
        }
        
        
        
        public static void deleteCourse(int courseId){
            Connection connection=pool.getConnection();
            try{
                Statement statement=connection.createStatement();
                String sql="delete from courses where courseid ="+courseId;
                statement.executeUpdate(sql);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            pool.returnConnection(connection);
        }
        
       

}
