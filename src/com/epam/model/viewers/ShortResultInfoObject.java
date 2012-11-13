package com.epam.model.viewers;

import com.epam.model.Question;

public class ShortResultInfoObject {
//	private int questionID;
	private Question question;
	private boolean isCorrect;
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}
