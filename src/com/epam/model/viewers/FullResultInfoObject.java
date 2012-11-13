package com.epam.model.viewers;

import java.util.List;

import com.epam.model.Answer;
import com.epam.model.Question;

public class FullResultInfoObject {
	private Question question;
	private boolean isCorrect;
	private List<Answer> answers;
	private Answer usersAnswer;
	
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
	public Answer getUsersAnswer() {
		return usersAnswer;
	}
	public void setUsersAnswer(Answer usersAnswer) {
		this.usersAnswer = usersAnswer;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}
