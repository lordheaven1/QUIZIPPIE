<%@ page import="java.util.List" %>
<%@ page import="com.quiz.model.Score" %>
<html>
<head><title>Student Scores</title></head>
<body>
<h2>All Quiz Scores</h2>
<table border="1" cellpadding="5">
<tr><th>Username</th><th>Score</th><th>Date</th></tr>
<%
    List<Score> scores = (List<Score>) request.getAttribute("scores");
    for (Score s : scores) {
%>
<tr>
  <td><%= s.getUsername() %></td>
  <td><%= s.getScore() %></td>
  <td><%= s.getQuizDate() %></td>
</tr>
<% } %>
</table>
<br><a href="teacherHome.jsp">Back</a>
</body>
</html>
