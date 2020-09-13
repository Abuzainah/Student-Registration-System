<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
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
		  left:80%;
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
	if(session.getAttribute("abc")==null){
		response.sendRedirect("StudentLogin.jsp");
	} %>
	
	<p>${isDropped}</p>
	
    <form class="box" action="Drop" method="POST">
    
        <label for="ID">Enter the ID of the course you want to drop:</label><br>
        <input type="text" id="ID" name="courseIdtoDrop"><br><br>
   
        <input type="submit" value="Drop">
      </form><br><br>
      <form  action="StudentLogout">
    		<input class="hi1" type="submit" value="Logout">
    	</form>
    	<br>
    	<form action="MyCourses.jsp">
    		<input class="hi2" type="submit" value="Check your courses">
    	</form><br>
    	<form action="StudentPage.jsp">
    		<input class="hi4" type="submit" value="Home Page">
    </form><br>
      
      
</body>
</html>