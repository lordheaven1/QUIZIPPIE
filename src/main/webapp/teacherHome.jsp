<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Teacher Dashboard</title></head>
<body>
    <h2>Welcome Teacher <%= session.getAttribute("user") %></h2>
    <a href="addQuestion.jsp">Add Question</a>
    <a href="logout">Logout</a>
</body>
</html>
