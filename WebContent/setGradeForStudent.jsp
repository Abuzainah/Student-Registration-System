<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="windows-1256">
		<title>Set Grade for Student</title>
		<link rel="stylesheet" type="text/css" href="styles.css">
		<style>
			h1{		
					text-align:center
					font-family: "Roboto", Helvetica, Arial, sans-serif;
					text-align:center;
					font-size:40px;
					top:10%;
					padding:40px;
					color:Black;
				}
				div{
				text-align:center;
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
		  top:100%;
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
		  top:100%;
		  left:70%;
		  transform:translate(-50%,-50%);
		
}
	
		</style>
	</head>
	<body>
	 <h1 class="txt">${complete}</h1>
	 <h1 class="txt">${Incomplete}</h1>
		<div class="container">  
			  <form id="contact" action="SetGrade" method="post">
				    <h3>Enter Student and Course Info</h3>
				    <h4>All Data fields must be filled</h4>
				    <fieldset>
				      <input name="studentId" placeholder="Enter Student ID" type="text" tabindex="1"  required autofocus>
				    </fieldset>
				    <fieldset>
				      <input name="CourseID" placeholder="Enter Course ID:" type="text" tabindex="2" required>
				    </fieldset>
				    <fieldset>
				      <input name="grade" placeholder="Enter Grade" type="text" tabindex="2" required>
				    </fieldset>
				    <fieldset>
				      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Set Grade</button>
				    </fieldset>    
			  </form>
		</div>
		<form action="InstructorLogout">
    		<input class="hi1" type="submit" value="Logout">
   		</form>
   		<form action="InstructorPage.jsp">
    		<input class="hi2" type="submit" value="Home Page">
    </form><br>
	</body>
</html>
