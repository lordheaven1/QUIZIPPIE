<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Quiz App</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="header">QUIZIPPIE – Online Quiz App</div>
	<div class="container">
		<h2>Add New Question</h2>

		<%
		if (request.getAttribute("message") != null) {
		%>
		<div class="success"><%=request.getAttribute("message")%></div>
		<%
		}
		%>
		<%
		if (request.getAttribute("error") != null) {
		%>
		<div class="error"><%=request.getAttribute("error")%></div>
		<%
		}
		%>

		<form method="post" action="addQuestion">
			<label>Question</label>
			<textarea name="question" rows="3" required></textarea>

			<label>Option 1</label> <input type="text" name="option1" required>
			...
			<button type="submit" class="button">Save Question</button>
		</form>


		<br> <a href="teacherHome.jsp">Back</a>
	</div>
	<!-- /.container -->
</body>
</html>

