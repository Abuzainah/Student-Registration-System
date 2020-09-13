<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
     <%@page import="com.abd.Enrollment"%>
    <%@page import="com.abd.EnrollmentDAO"%>
     <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="windows-1256">
		<title>Students Absence</title>
		<link rel="stylesheet" href="studentstyle.css">
	<style type="text/css">
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
		  left:50%;
		  transform:translate(-50%,-50%);
		
}
.hi3 {
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
		  left:60%;
		  transform:translate(-50%,-50%);
		
}
	.hi4 {
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
		<h1>${errorEntry}</h1> 
		<form class="box" action="AbsenceList">
	        <h1>Enter the id of the student you want to check absence times for:</h1><br>
	        <input class="textInput" placeholder="Enter ID" id="ID" name="studentID"><br><br>
	        <input  type="submit" value="Show Absence List">
	    </form><br>
	    <form action="setAbsenceForStudent.jsp">
	    		<input class="hi2" type="submit" value="Increase absence for student">
	    </form>
	    <form action="InstructorPage.jsp">
    		<input class="hi4" type="submit" value="Home Page">
    </form><br>
    <form action="InstructorLogout">
    		<input class="hi1" type="submit" value="Logout">
    </form><br>
	</body>
</html>