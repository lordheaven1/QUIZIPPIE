<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Student Dashboard</title></head>
<body>
    <h2>Welcome Student <%= session.getAttribute("user") %></h2>
    <a href="startQuiz">Start Quiz</a> |
    <a href="logout">Logout</a>
</body>
</html>
