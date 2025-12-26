package com.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.quiz.DBConnectionManager;
import com.quiz.model.Score;


//com.quiz.dao.ScoreDAO
public class ScoreDAO {
	// com.quiz.dao.ScoreDAO add:
	public List<Score> findAllScores() {
	    List<Score> list = new ArrayList<>();
	    String sql = "SELECT username, score, quiz_date FROM scores ORDER BY quiz_date DESC";
	    try (Connection conn = DBConnectionManager.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        while (rs.next()) {
	            Score s = new Score();
	            s.setUsername(rs.getString("username"));
	            s.setScore(rs.getInt("score"));
	            s.setQuizDate(rs.getTimestamp("quiz_date"));
	            list.add(s);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}

 public void saveScore(String username, int score) {
     String sql = "INSERT INTO scores (username, score) VALUES (?, ?)";
     try (Connection conn = DBConnectionManager.getConnection();
          PreparedStatement ps = conn.prepareStatement(sql)) {
         ps.setString(1, username);
         ps.setInt(2, score);
         ps.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
}

