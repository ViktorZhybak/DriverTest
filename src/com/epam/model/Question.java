package com.epam.model;

public class Question {
	private int questionID;
	private String questionContent;

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", questionContent="
				+ questionContent + "]";
	}
	
}
