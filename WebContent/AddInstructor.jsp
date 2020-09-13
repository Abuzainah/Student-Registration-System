<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>


<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>AddInstructorPage</title>
	    <link rel="stylesheet" href="styles.css">
	     <style>
	    	.title{
				position: absolute;
				top:10%;
				left:50%;
				transform:translate(-50%,-50%);
				font-size: 30px;
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
		  top:90%;
		  left:50%;
		  transform:translate(-50%,-50%);
		
}
		
   		 </style>
	</head>
	<body>
		<%
		//response.setHeader("Cache-Control", "no-chache, no-store ,must-revalidate");
		if(session.getAttribute("id")==null){
			response.sendRedirect("AdminLogin.jsp");
		} %>
	<h2 class="title"> ${successMessage}</h2>
	<h2 class="title"> ${errorMessage}</h2>
	<div class="container">  
		  <form id="contact" action="AddInstructor" method="post">
		    <h3>Enter Instructor Info</h3>
		    <h4>All Data fields must be filled</h4>
		    <fieldset>
		      <input name="id" placeholder="Enter ID" type="text" tabindex="1" required autofocus>
		    </fieldset>
		    <fieldset>
		      <input name="firstName" placeholder="Enter first name:" type="text" tabindex="2" required>
		    </fieldset>
		    <fieldset>
		      <input name="lastName" placeholder="Enter last name:" type="text" tabindex="3" required>
		    </fieldset>
		    <fieldset>
		      <input name="password" placeholder="Create password:" type="text" tabindex="3" required>
		    </fieldset>
		    <fieldset>
		      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Create An Instructor</button>
		    </fieldset>
		    
		  </form>
	</div>
	<form action="AdminPage.jsp">
    	<input class="hi" type="submit" value="Home Page">
    </form>
	</body>
</html>

