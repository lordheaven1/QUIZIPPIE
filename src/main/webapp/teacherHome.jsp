<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Teacher Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="header">QUIZIPPIE – Teacher Dashboard</div>
<div class="container">

    <h2>Welcome, <%= session.getAttribute("user") %></h2>

    <div class="nav">
        <a href="addQuestion.jsp">Add Question</a>
        <a href="viewScores">View Scores</a>
        <a href="logout">Logout</a>
    </div>

    <p>Use this dashboard to create questions and monitor student performance.</p>

</div>
</body>
</html>
