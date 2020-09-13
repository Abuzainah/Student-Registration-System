<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@page import="com.abd.Course"%>
    <%@page import="com.abd.CourseDAO"%>
     <%@page import="java.util.*"%>
   
    <%  ArrayList<Course>courseList=CourseDAO.getAvailableCourse(); %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="studentstyle.css">
 <style>
    *{
        background-color: rgb(173, 170, 170);
    }
	#customers {
	  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	  border-collapse: collapse;
	  width: 50%;
	  height:50%;
	  text-align: center;
	  padding: 100px;
	}
	
	#customers td, #customers th {
	  border: 1px solid white;
	  padding: 8px;
	}
	
	#customers tr:nth-child(even){background-color: #f2f2f2;}
	
	#customers tr:hover {background-color: #ddd;}
	
	#customers th {
	  padding-top: 12px;
	  padding-bottom: 12px;
	  text-align: left;
	  background-color: black;
	  color: white;
	  text-align: center;
}
.table{
	padding: 40px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
}
</style>
<meta charset="windows-1256">
<title>Available Course</title>
<style>

		.hi1 {
		  background-color: Gray;
		  border: none;
		  color: white;
		  padding: 15px 32px;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		  font-size: 16px;
		  margin: 4px 2px;
		  cursor: pointer;
		  font-family: "Times New Roman", Times, serif;
		  position: absolute;
		  top:90%;
		  left:20%;
		  transform:translate(-50%,-50%);
		
}
.hi2 {
		  background-color: Gray;
		  border: none;
		  color: white;
		  padding: 15px 32px;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		  font-size: 16px;
		  margin: 4px 2px;
		  cursor: pointer;
		  font-family: "Times New Roman", Times, serif;
		  position: absolute;
		  top:90%;
		  left:80%;
		  transform:translate(-50%,-50%);
		
}

</style>
</head>
<body>
	<table class="table" id="customers" border="1">
		
			<tr><th>Course ID</th><th>Course Name</th></tr>	
				
			<%
				for(Course c: courseList){			
			%>
			<tr>
				<td><%=c.getCourseId()%></td>
				<td><%=c.getCourseName()%></td>
			</tr>
		<%}%>
		</table><br><br>
		
		<form action="Register.jsp">
    		<input class="hi1" type="submit" value="Register in a course">
    	</form>
		
		<br>
		
		<form action="StudentLogout">
    		<input class="hi2" type="submit" value="Logout">
    	</form>
</body>
</html>