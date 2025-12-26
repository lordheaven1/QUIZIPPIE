<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Quiz Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="login-wrapper">
    <h1 class="login-title">Welcome to QUIZIPPIE</h1>
    <p class="login-subtitle">
        Sign in as <b>teacher</b> or <b>student</b> to manage and take quizzes.
    </p>

    <% if (request.getAttribute("error") != null) { %>
        <div class="error"><%= request.getAttribute("error") %></div>
    <% } %>

    <form class="login-form" method="post" action="login">
        <label for="username">Username</label>
        <input id="username" type="text" name="username"
               placeholder="Enter your username" required>

        <label for="password">Password</label>
        <input id="password" type="password" name="password"
               placeholder="Enter your password" required>

        <button type="submit" class="button-primary">Login</button>

        <div class="login-meta">
            <span>Demo: teacher1 / student1</span>
            <a href="#">Forgot password?</a>
        </div>
    </form>
</div>

</body>
</html>
