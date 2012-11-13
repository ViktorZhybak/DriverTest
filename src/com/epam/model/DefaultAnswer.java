package com.epam.model;

public class DefaultAnswer extends Answer {
	private int answerID = 0;
	private String answerContent = "No answer";
	private boolean isCorrect = false;
	
	public int getAnswerID() {
		return answerID;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
}
