<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="studentstyle.css">
</head>
<body>
    <div class="wrapper">
        <nav class ="navbar">
            <ul>
                <li><a class="active" href="index.jsp">Home</a></li>
                <li><a href="StudentLogin.jsp">Student</a></li>
                <li><a href="InstructorLogin.jsp">Instructor</a></li>
                <li><a href="AdminLogin.jsp">Admin</a></li>
            </ul>
        </nav>
       
    </div>
    <form class="box" action="LoginAdmin" method="post">
        <h1>Login</h1>
        ${message}
        <input type="number" name="adminId" placeholder="ID">
        <input type="password" name="adminPassword" placeholder="Password">
        <input type="submit"   placeholder="Login">
        
    </form>
</body>
</html>