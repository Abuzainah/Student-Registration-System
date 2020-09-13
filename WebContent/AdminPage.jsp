<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>AdminPage</title>
<link rel="stylesheet" type="text/css" href="styles.css">
	
	<style type="text/css">
	h1{
	text-align: center;
	font-size: 50px;
	font-family: "Times New Roman", Times, serif;
	top:20%;
	left:50%;
	padding: 15px 32px;
	}
	
	.btn{
	border: 2px solid #000;
	padding: 2px 2px;
	margin:10px
	color:#000;
	}
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
		  top:60%;
		  left:50%;
		  transform:translate(-50%,-50%);
		
}
	a{
		text-decoration:none;
	}
	.body {
	  font-family: "Roboto", Helvetica, Arial, sans-serif;
	  font-weight: 100;
	  font-size: 12px;
	  line-height: 30px;
}
.s{
	position: absolute;
	top:50%;
	left:50%;
	transform:translate(-50%,-50%);
	font-size: 30px;
}


.title{
	position: absolute;
	top:30%;
	left:50%;
	transform:translate(-50%,-50%);
	font-size: 70px;
}
	</style>
</head>
<body>
	
	<%
		//response.setHeader("Cache-Control", "no-chache, no-store ,must-revalidate");
		//responde.setHeader("Pragma","no-cache")//works with HTTP 1.0
		//responde.setHeader("Expires","0");//if you're dealing with proxy servers
		if(session.getAttribute("id")==null){
			response.sendRedirect("AdminLogin.jsp");
		}
	%>
	<h1>Please select the operation you'd like to perform : </h1>
	<h1 class="title">${welcome}</h1>
	
    <div class="s">
	    <a class="btn" href="AddStudent.jsp">Create Student</a>
	    <a class="btn" href="AddInstructor.jsp">Create Instructor</a>
	    <a class="btn" href="AddCourse.jsp">Create Course</a>  
    </div>
    <form action="AdminLogout">
    	<input class="hi" type="submit" value="Logout">
    </form>
    
</body>
</html>