<%@ page import="java.util.List" %>
<%@ page import="com.quiz.model.QuizQuestion" %>
<%
    List<QuizQuestion> questions = (List<QuizQuestion>) session.getAttribute("questions");
    if (questions == null) {
        response.sendRedirect("studentHome.jsp");
        return;
    }
%>
<html>
<head><title>Quiz</title></head>
<body>
<h2>Quiz</h2>

<form method="post" action="submitQuiz">
<%
    for (int i = 0; i < questions.size(); i++) {
        QuizQuestion q = questions.get(i);
%>
    <p><b>Q<%= i+1 %>:</b> <%= q.getQuestion() %></p>
    <%
        String[] opts = q.getOptions();
        for (int j = 0; j < opts.length; j++) {
    %>
        <input type="radio" name="answer<%= i %>" value="<%= j+1 %>">
        <%= opts[j] %><br>
    <% } %>
    <hr>
<% } %>

    <button type="submit">Submit Quiz</button>
</form>

</body>
</html>
