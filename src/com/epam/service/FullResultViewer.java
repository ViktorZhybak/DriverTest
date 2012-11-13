package com.epam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.model.Answer;
import com.epam.model.DefaultAnswer;
import com.epam.model.Question;
import com.epam.model.Test;
import com.epam.model.viewers.FullResultInfoObject;
import com.epam.model.viewers.ShortResultInfoObject;

public class FullResultViewer {
	public static List<FullResultInfoObject> viewFullResult(Test test,
			List<ShortResultInfoObject> shortResultInfo) {
		List<FullResultInfoObject> fullResultInfo = new ArrayList<FullResultInfoObject>();

		Map<Integer, Integer> mapOfUsersAnswers = test.getMapOfUsersAnswers();
		Map<Question, List<Answer>> mapOfQuestionsAnwers = test
				.getMapOfQuestionsAnwers();

		for (ShortResultInfoObject shortOb : shortResultInfo) {

			Question question = shortOb.getQuestion();
			List<Answer> answers = mapOfQuestionsAnwers.get(question);
			boolean isCorrect = shortOb.isCorrect();

			Answer usersAnswer = new DefaultAnswer();
			int usersAnswerID = mapOfUsersAnswers.get(question.getQuestionID());

			if (usersAnswerID != 0) {
				for (Answer answer : answers) {
					if (answer.getAnswerID() == usersAnswerID) {
						usersAnswer = answer;
					}
				}
			}

			FullResultInfoObject fullOb = new FullResultInfoObject();
			fullOb.setQuestion(question);
			fullOb.setCorrect(isCorrect);
			fullOb.setAnswers(answers);
			fullOb.setUsersAnswer(usersAnswer);

			fullResultInfo.add(fullOb);
		}
		return fullResultInfo;
	}
}
