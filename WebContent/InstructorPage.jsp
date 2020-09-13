<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="windows-1256">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="styles.css">
		<style>
				.hi {
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
				  left:50%;
				  transform:translate(-50%,-50%);	
				}
				.center{
					text-align:center;
					font-family: "Roboto", Helvetica, Arial, sans-serif;
					font-size:30px;
					display: block;
					margin:60px
				}
				a{
					text-decoration:none;
				}
				h1{
					font-family: "Roboto", Helvetica, Arial, sans-serif;
					text-align:center;
					font-size:40px;
					top:10%;
					padding:10px;
					color:Black;
				}
		</style>
		
	</head>
	<body>
		<%
			response.setHeader("Cache-Control", "no-chache, no-store ,must-revalidate");
			//responde.setHeader("Pragma","no-cache")//works with HTTP 1.0
			//responde.setHeader("Expires","0");//if you're dealing with proxy servers
			if(session.getAttribute("id")==null){
				response.sendRedirect("InstructorLogin.jsp");
			}
		%>
		
		<h1>What kind of operations you'd like to perform:</h1>
		<p class="center"><a href="checkStudentsAbsence.jsp">Check absence times for students</a></p>
		<p class="center"><a href="checkStudentGrades.jsp">Check student grades</a></p>
		<p class="center"><a href="listOfStudents.jsp">Check the list of students you teach</a></p>
		<p class="center"><a href="listOfCourses.jsp">Check the list of courses you teach</a></p>
		<p class="center"><a href="setGradeForStudent.jsp">Set a grade for a student</a></p>
		<p class="center"><a href="setAbsenceForStudent.jsp">Set absence for a student</a></p>
		
		<form action="InstructorLogout">
    		<input class="hi" type="submit" value="Logout">
   		</form>
	</body>
</html>