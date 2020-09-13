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
    
    
    <form class="box" action="InstructorLogin" method="POST">
        <h1>Login</h1>
        <input type="number" name="ID" placeholder="ID">
        <input type="password" name="password" placeholder="Password">
        <input type="submit" name="" placeholder="Login">
    </form>
</body>
</html>