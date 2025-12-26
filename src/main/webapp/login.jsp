<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Quiz Login</title></head>
<body>
    <h2>Quiz App Login</h2>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red"><%= request.getAttribute("error") %></p>
    <% } %>
    <form method="post" action="login">
        Username: <input type="text" name="username" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        <button type="submit">Login</button>
    </form>
</body>
</html>
