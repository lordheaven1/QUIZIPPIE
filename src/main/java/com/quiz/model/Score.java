package com.quiz.model;
public class Score 
{
 private String username;
 private int score;
 private java.sql.Timestamp quizDate;
 public String getUsername() {
	return username;
 }
 public void setUsername(String username) {
	this.username = username;
 }
 public int getScore() {
	return score;
 }
 public void setScore(int score) {
	this.score = score;
 }
 public java.sql.Timestamp getQuizDate() {
	return quizDate;
 }
 public void setQuizDate(java.sql.Timestamp quizDate) {
	this.quizDate = quizDate;
 }
 
}

