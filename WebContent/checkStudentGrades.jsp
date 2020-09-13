<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="windows-1256">
		<title>Students Grades</title>
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
	
	 ${errorEntry2} 
		<form class="box" action="GradeList" method="POST">
	        <label for="ID">Enter the id of the student you want to check grades for:</label><br>
	        <input type="text" placeholder="Enter ID" id="ID" name="studentID"><br><br>
	        <input type="submit" value="Show Grade List">
	    </form>
	    <br>
	    
	    <form action="setGradeForStudent.jsp">
	    		<input class="hi2" type="submit" value="set grade for a student">
	    </form>
	    <form action="InstructorLogout">
    		<input class="hi1" type="submit" value="Logout">
    </form><br>
     <form action="InstructorPage.jsp">
    		<input class="hi4" type="submit" value="Home Page">
    </form><br>
	</body>
</html>