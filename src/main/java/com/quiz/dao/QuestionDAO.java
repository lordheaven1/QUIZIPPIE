package com.quiz.dao;

import com.quiz.DBConnectionManager;
import com.quiz.model.QuizQuestion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
    public void addQuestion(QuizQuestion question, String createdBy) {
        String sql = "INSERT INTO questions (question, option1, option2, option3, option4, correct_answer, created_by) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, question.getQuestion());
            stmt.setString(2, question.getOptions()[0]);
            stmt.setString(3, question.getOptions()[1]);
            stmt.setString(4, question.getOptions()[2]);
            stmt.setString(5, question.getOptions()[3]);
            stmt.setInt(6, question.getCorrectAnswer());
            stmt.setString(7, createdBy);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<QuizQuestion> getRandomQuestions(int count) {
        List<QuizQuestion> questions = new ArrayList<>();
        String sql = "SELECT * FROM questions ORDER BY RAND() LIMIT ?";
        
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, count);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                QuizQuestion q = new QuizQuestion();
                q.setId(rs.getInt("id"));
                q.setQuestion(rs.getString("question"));
                q.setOptions(new String[]{
                    rs.getString("option1"),
                    rs.getString("option2"),
                    rs.getString("option3"),
                    rs.getString("option4")
                });
                q.setCorrectAnswer(rs.getInt("correct_answer"));
                questions.add(q);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
