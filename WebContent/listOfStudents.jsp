<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@page import="com.abd.EnrollmentDAO"%>
    <%@page import="com.abd.Enrollment"%>
     <%@page import="java.util.*"%>
   
    <%
    HttpSession session2=request.getSession();
    int x=(Integer)session2.getAttribute("id");
    ArrayList<Enrollment>studentList=EnrollmentDAO.getStudentInstructorTeach(x);%>
<!DOCTYPE html>
<html>
<head>

<meta charset="windows-1256">
<title>Students List</title>
		<link rel="stylesheet" href="studentstyle.css">
		<style>
  *{
        background-color: rgb(173, 170, 170);
    }
	#customers {
	  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	  border-collapse: collapse;
	  width: 50%;
	  height:10%;
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
    top: 30%;
    left: 50%;
    transform: translate(-50%,-50%);
}
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
		  left:30%;
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
		  left:70%;
		  transform:translate(-50%,-50%);
		
}
</style>
</head>
<body>
	<table class="table" id="customers" border="1">
		
			<tr><th>Course ID</th><th>Course name</th><th>Student ID</th><th>Student first name</th><th>Student last name</th><th>Absence Times</th><th>Grade</th></tr>	
				
			<%
				for(Enrollment c: studentList){			
			%>
			<tr>
				<td><%=c.getCourseId()%></td>
				<td><%=c.getCourseName()%></td>
				<td><%=c.getStudentId()%></td>
				<td><%=c.getStudentFirstName()%></td>
				<td><%=c.getStudentLastName()%></td>
				<td><%=c.getAbsense()%></td>
				<td><%=c.getGrade()%></td>
			</tr>
		<%}%>
		</table>
		
		<form action="InstructorLogout">
    		<input class="hi1" type="submit" value="Logout">
   		</form>
   		<form action="InstructorPage.jsp">
    		<input class="hi2" type="submit" value="Home Page">
    </form><br>
</body>
</html>