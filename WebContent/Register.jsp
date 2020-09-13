<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>RegisterPage</title>
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
		  left:40%;
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
<%
		response.setHeader("Cache-Control", "no-chache, no-store ,must-revalidate");
		//responde.setHeader("Pragma","no-cache")//works with HTTP 1.0
		//responde.setHeader("Expires","0");//if you're dealing with proxy servers
		if(session.getAttribute("abc")==null){
			response.sendRedirect("StudentLogin.jsp");
		}
	%>
	
<h1 class="txt">${x}</h1>
	 <form class="box" action="Register" method="POST">
  
        <label for="fname">Enter Course ID:</label><br>
        <input type="text" id="fname" name="courseId"><br>
        <label for="fname">Enter Instructor ID:</label><br>
        <input type="text" id="fname" name="instructorId"><br>
    
        <input type="submit" value="Submit">
    </form><br>
    
    <form action="StudentLogout">
    		<input class="hi1" type="submit" value="Logout">
    </form><br>
    
    <form action="AvailableCourses.jsp">
    		<input class="hi2" type="submit" value="Check available courses">
    </form><br>
    <form action="AvailableInstructors.jsp">
    		<input class="hi3" type="submit" value="Check available Instructors">
    </form><br>
    <form action="StudentPage.jsp">
    		<input class="hi4" type="submit" value="Home Page">
    </form><br>
	
    
    
</body>
</html>