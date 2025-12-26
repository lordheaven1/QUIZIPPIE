package com.quiz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LogoutServlet
 */
//com.quiz.servlet.LogoutServlet
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws IOException {
     HttpSession session = req.getSession(false);
     if (session != null) {
         session.invalidate();
     }
     resp.sendRedirect("login.jsp");
 }
}
