package com.epam.model.viewers;

import java.util.List;

import com.epam.model.Answer;
import com.epam.model.Question;

public class QuestionAnswers {
	private boolean isLast;
	private Question question;
	private List<Answer> answers;
	
	public boolean isLast() {
		return isLast;
	}
	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
