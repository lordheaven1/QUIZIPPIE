package com.quiz.model;

public class QuizQuestion {
    private int id;
    private String question;
    private String[] options = new String[4];
    private int correctAnswer;
    
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }
    public String[] getOptions() { return options; }
    public void setOptions(String[] options) { this.options = options; }
    public int getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(int correctAnswer) { this.correctAnswer = correctAnswer; }
}
