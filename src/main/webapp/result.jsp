<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Quiz App</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="header">QUIZIPPIE – Online Quiz App</div>
<div class="container">
    <!-- page content here -->

<h2>Your Result</h2>
<p>You scored <b><%= request.getAttribute("score") %></b> out of 
   <b><%= request.getAttribute("total") %></b>.</p>
<a href="studentHome.jsp">Back to Home</a>
</div> <!-- /.container -->
</body>
</html>

