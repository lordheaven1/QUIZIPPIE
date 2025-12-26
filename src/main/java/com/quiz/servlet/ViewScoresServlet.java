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
import com.quiz.model.Score;

/**
 * Servlet implementation class ViewScoreServlet
 */
//com.quiz.servlet.ViewScoresServlet
@WebServlet("/viewScores")
public class ViewScoresServlet extends HttpServlet {
 private ScoreDAO scoreDAO = new ScoreDAO();

 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {

     HttpSession session = req.getSession(false);
     if (session == null || !"teacher".equals(session.getAttribute("role"))) {
         resp.sendRedirect("login.jsp");
         return;
     }

     List<Score> scores = scoreDAO.findAllScores();
     req.setAttribute("scores", scores);
     req.getRequestDispatcher("teacherScores.jsp").forward(req, resp);
 }
}
