package com.quiz.servlet;

import java.io.IOException;
import java.util.List;

import com.quiz.dao.QuestionDAO;
import com.quiz.model.QuizQuestion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//com.quiz.servlet.StartQuizServlet
@WebServlet("/startQuiz")
public class StartQuizServlet extends HttpServlet {
 private QuestionDAO questionDAO = new QuestionDAO();

 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {

     HttpSession session = req.getSession(false);
     if (session == null || !"student".equals(session.getAttribute("role"))) {
         resp.sendRedirect("login.jsp");
         return;
     }

     // get 10 random questions
     List<QuizQuestion> questions = questionDAO.getRandomQuestions(10);
     session.setAttribute("questions", questions);
     session.setAttribute("totalQuestions", questions.size());

     resp.sendRedirect("quiz.jsp");
 }
}

