package com.quiz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.quiz.dao.ScoreDAO;
import com.quiz.model.QuizQuestion;

/**
 * Servlet implementation class SubmitQuizServlet
 */
//com.quiz.servlet.SubmitQuizServlet
@WebServlet("/submitQuiz")
public class SubmitQuizServlet extends HttpServlet {
 private ScoreDAO scoreDAO = new ScoreDAO();

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {

     HttpSession session = req.getSession(false);
     if (session == null || !"student".equals(session.getAttribute("role"))) {
         resp.sendRedirect("login.jsp");
         return;
     }

     String username = (String) session.getAttribute("user");
     @SuppressWarnings("unchecked")
     List<QuizQuestion> questions =
             (List<QuizQuestion>) session.getAttribute("questions");

     int score = 0;
     for (int i = 0; i < questions.size(); i++) {
         String ans = req.getParameter("answer" + i);
         if (ans != null) {
             int selected = Integer.parseInt(ans);
             if (selected == questions.get(i).getCorrectAnswer()) {
                 score++;
             }
         }
     }

     scoreDAO.saveScore(username, score);

     req.setAttribute("score", score);
     req.setAttribute("total", questions.size());

     // clear questions from session
     session.removeAttribute("questions");

     req.getRequestDispatcher("result.jsp").forward(req, resp);
 }
}
