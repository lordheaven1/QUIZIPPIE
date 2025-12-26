package com.quiz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.quiz.dao.QuestionDAO;
import com.quiz.model.QuizQuestion;

//com.quiz.servlet.AddQuestionServlet
@WebServlet("/addQuestion")
public class AddQuestionServlet extends HttpServlet {
	private QuestionDAO questionDAO = new QuestionDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		String role = (session != null) ? (String) session.getAttribute("role") : null;
		if (role == null || !"teacher".equals(role)) {
			resp.sendRedirect("login.jsp");
			return;
		}

		String qText = req.getParameter("question");
		String o1 = req.getParameter("option1");
		String o2 = req.getParameter("option2");
		String o3 = req.getParameter("option3");
		String o4 = req.getParameter("option4");
		int correct = Integer.parseInt(req.getParameter("correctAnswer"));

		QuizQuestion q = new QuizQuestion();
		q.setQuestion(qText);
		q.setOptions(new String[] { o1, o2, o3, o4 });
		q.setCorrectAnswer(correct);

		String createdBy = (String) session.getAttribute("user");

		try {
			questionDAO.addQuestion(q, createdBy);
			req.setAttribute("message", "Question added successfully");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error adding question");
		}

		req.getRequestDispatcher("addQuestion.jsp").forward(req, resp);
	}
}
