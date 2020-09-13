<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Assign Course to Instructor</title>
    </head>
    
    <body>
	  <%
		response.setHeader("Cache-Control", "no-chache, no-store ,must-revalidate");
		//responde.setHeader("Pragma","no-cache")//works with HTTP 1.0
		//responde.setHeader("Expires","0");//if you're dealing with proxy servers
		if(session.getAttribute("id")==null){
			response.sendRedirect("AdminLogin.jsp");
		}
	%>
	<p>${successMessage}</p>
	<p>${errorMessage}</p>
        <form action="Assign" method="POST">
            <label for="fname">Enter Course Id:</label><br>
            <input type="text" id="fname" name="courseId"><br>
            <label for="fname">Enter Instructor Id:</label><br>
            <input type="text" id="fname" name="instructorId"><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>