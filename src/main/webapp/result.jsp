<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Quiz Result</title></head>
<body>
<h2>Your Result</h2>
<p>You scored <b><%= request.getAttribute("score") %></b> out of 
   <b><%= request.getAttribute("total") %></b>.</p>
<a href="studentHome.jsp">Back to Home</a>
</body>
</html>
