package com.epam.model;

public class Answer {
	private int answerID;
	private String answerContent;
	boolean isCorrect;

	public int getAnswerID() {
		return answerID;
	}

	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return "Answer [answerID=" + answerID + ", answerContent="
				+ answerContent + ", isCorrect=" + isCorrect + "]";
	}
	
}
