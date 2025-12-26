package com.quiz.servlet;

import com.quiz.dao.UserDAO;
import com.quiz.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	System.out.println("LOGIN TRY -> user='" + username + "', pass='" + password + "'");

        
        User user = userDAO.authenticate(username, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user.getUsername());
            session.setAttribute("role", user.getRole());
            
            if ("teacher".equals(user.getRole())) {
                resp.sendRedirect("teacherHome.jsp");
            } else {
                resp.sendRedirect("studentHome.jsp");
            }
        } else {
            req.setAttribute("error", "Invalid credentials");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
