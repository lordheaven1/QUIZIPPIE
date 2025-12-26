<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Quiz App</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="header">QUIZIPPIE – Online Quiz App</div>
	<div class="container">
		<!-- page content here -->

		<h2>
			Welcome Student
			<%=session.getAttribute("user")%></h2>
		<a href="startQuiz">Start Quiz</a> | <a href="logout">Logout</a>
	</div>
	<!-- /.container -->
</body>
</html>

