<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Add Question</title></head>
<body>
<h2>Add New Question</h2>

<% if (request.getAttribute("message") != null) { %>
  <p style="color:green"><%= request.getAttribute("message") %></p>
<% } %>
<% if (request.getAttribute("error") != null) { %>
  <p style="color:red"><%= request.getAttribute("error") %></p>
<% } %>

<form method="post" action="addQuestion">
  Question:<br>
  <textarea name="question" required></textarea><br><br>

  Option 1: <input type="text" name="option1" required><br>
  Option 2: <input type="text" name="option2" required><br>
  Option 3: <input type="text" name="option3" required><br>
  Option 4: <input type="text" name="option4" required><br><br>

  Correct option (1-4):
  <input type="number" name="correctAnswer" min="1" max="4" required><br><br>

  <button type="submit">Save</button>
</form>

<br><a href="teacherHome.jsp">Back</a>
</body>
</html>
